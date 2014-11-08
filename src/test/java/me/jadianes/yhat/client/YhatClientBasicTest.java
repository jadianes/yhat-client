package me.jadianes.yhat.client;

import junit.framework.Assert;
import me.jadianes.yhat.client.basic.YhatClientBasic;
import me.jadianes.yhat.config.YhatConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertTrue;

/**
 * @author Jose A. Dianes <jadianes@gmail.com>
 *
 */
@ContextConfiguration(locations = {"/test-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class YhatClientBasicTest {

    @Autowired
    YhatConfig yhatConfig;

    private YhatClientBasic yhatClient;
    private RestTemplate restTemplate;

    @Before
    public void init() {
        restTemplate = new RestTemplate();
        yhatClient = new YhatClientBasic(yhatConfig,restTemplate);
    }

    @Test
    public void testPredict() throws IOException {
        Map<String, String> input = new HashMap<String,String>();
        input.put("from.row","1");
        input.put("to.row","10");
        LimeDataSet res = yhatClient.predict(
                input,
                "limeData",
                LimeDataSet.class);

        assertNotNull(res);
        assertNotNull(res.result);
        assertTrue(res.result.x.length == 10);

    }
}
