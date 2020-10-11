package cn.zslstudy.base.Lib;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @ClassName WeixinConfig
 * @Author User
 * @date 2020.10.11 11:43
 */
@Component
@ConfigurationProperties(prefix = "weixin")
public class WeixinConfig {
    private String appId;
    private String appSecret;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }
}
