package me.jadianes.yhat.client.basic;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.jadianes.yhat.client.YhatClientAbstract;
import me.jadianes.yhat.config.YhatConfig;
import me.jadianes.yhat.model.Prediction;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.apache.commons.codec.binary.Base64;

import java.io.IOException;
import java.util.Map;

/**
 * @author Jose A. Dianes <jadianes@gmail.com>
 *
 */
public class YhatClientBasic extends YhatClientAbstract {

    public YhatClientBasic(YhatConfig config, RestTemplate restTemplate) {
        super(config, restTemplate);
    }

    /**
     * Returns a raw json String from a yhat precition
     *
     * @param input
     * @param modelName
     * @return
     */
    public String predictRaw(Map<String, String> input, String modelName) {
        String url = String.format("%s://%s/%s/models/%s/",
                config.getProtocol(), config.getHostName(), config.getUserName(), modelName);

        MultiValueMap<String, String> map = asMultiValueMap(input);

        String userCredentials = this.config.getUserName()+":"+this.config.getApiKey();
        String basicAuth = "Basic " + new String(Base64.encodeBase64(
                userCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", basicAuth);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        String jsonResult = this.restTemplate.postForObject(url, request, String.class);

        return jsonResult;
    }

    /**
     * Maps a yhat prediction into a Json object
     *
     * @param input
     * @param modelName
     * @param clazz
     * @param <T>
     * @return
     * @throws IOException
     */
    public <T extends Prediction> T predict(Map<String, String> input, String modelName, Class<T> clazz) throws IOException {
        String jsonResponse = predictRaw(input,modelName);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonResponse, clazz);

    }

    private MultiValueMap<String, String> asMultiValueMap(Map<String, String> input) {
        MultiValueMap<String, String> res = new LinkedMultiValueMap<String, String>();

        for (Map.Entry<String, String> entry: input.entrySet()) {
            res.add(entry.getKey(),entry.getValue());
        }

        return res;
    }


}
