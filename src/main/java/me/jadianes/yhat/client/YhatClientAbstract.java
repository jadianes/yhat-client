package me.jadianes.yhat.client;

import me.jadianes.yhat.config.YhatConfig;
import org.springframework.web.client.RestTemplate;

/**
 * @author Jose A. Dianes <jadianes@gmail.com>
 *
 */
public abstract class YhatClientAbstract {

    protected YhatConfig config;
    protected RestTemplate restTemplate;

    protected YhatClientAbstract(YhatConfig config, RestTemplate restTemplate) {
        this.config = config;
        this.restTemplate = restTemplate;
    }

    public YhatConfig getConfig() {
        return config;
    }

}
