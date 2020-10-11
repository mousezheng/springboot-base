package cn.zslstudy.base.Service;

import cn.zslstudy.base.Dao.UserInfoRepo;
import cn.zslstudy.base.Entity.UserInfoEntity;
import cn.zslstudy.base.Lib.WeixinConfig;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Description
 * @ClassName WeixinService
 * @Author User
 * @date 2020.10.11 11:53
 */
@Service
public class WeixinService {

    @Autowired
    HttpClient httpClient;

    @Autowired
    WeixinConfig weixinConfig;

    @Autowired
    UserInfoRepo userInfoRepo;

    public Map<String, String> code2Session(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?" +
                "appid=" + weixinConfig.getAppId() +
                "&secret=" + weixinConfig.getAppSecret() +
                "&js_code=" + code +
                "&grant_type=authorization_code";
        Map<String, String> $responseObj = (Map<String, String>) JSON.parse(httpClient.get(url));
        return $responseObj;
    }

    public String getAccessToken() {
        String url = "https://api.weixin.qq.com/cgi-bin/token?" +
                "appid=" + weixinConfig.getAppId() +
                "&secret=" + weixinConfig.getAppSecret() +
                "&grant_type=client_credential";
        Map<String, String> $responseObj = (Map<String, String>) JSON.parse(httpClient.get(url));
        return $responseObj.get("access_token");
    }

    public void saveUserInfo(UserInfoEntity userInfo) {
        userInfo.setAddTime((int) System.currentTimeMillis());
        userInfoRepo.save(userInfo);
    }
}
