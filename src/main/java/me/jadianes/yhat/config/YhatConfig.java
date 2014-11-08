package me.jadianes.yhat.config;

/**
 * @author Jose A. Dianes <jadianes@gmail.com>
 *
 */
public class YhatConfig {
    private String userName;
    private String apiKey;
    private String hostName;
    private String protocol;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}
