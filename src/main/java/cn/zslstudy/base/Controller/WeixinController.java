package cn.zslstudy.base.Controller;

import cn.zslstudy.base.Entity.UserInfoEntity;
import cn.zslstudy.base.Service.SessionService;
import cn.zslstudy.base.Service.WeixinService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @ClassName LoginController
 * @Author User
 * @date 2020.10.11 11:24
 */
@RestController()
@RequestMapping("/weixin/")
public class WeixinController {

    @Autowired
    private WeixinService weixinService;

    @Autowired
    private SessionService sessionService;

    @RequestMapping("loginByCode/{code}")
    public String loginByCode(@PathVariable String code) {
        Map<String, String> loginInfo = weixinService.code2Session(code);
        Map<String, String> sessionInfo = new HashMap<>();
        sessionInfo.put("openid", loginInfo.get("openid"));
        sessionInfo.put("session_key", loginInfo.get("session_key"));
        sessionInfo.put("unionid", loginInfo.get("unionid"));
        String token = DigestUtils.md5DigestAsHex(loginInfo.get("session_key").getBytes());
        loginInfo.put("token", token);
        sessionService.save(token, sessionInfo);
        return JSONObject.toJSONString(loginInfo);
    }

    @RequestMapping("getAccessToken")
    public String getAccessToken() {
        return weixinService.getAccessToken();
    }

    @RequestMapping("testSession/{token}")
    public String testSession(@PathVariable String token) {
        Map<String, String> sessionInfo = sessionService.getSessionInfo(token);
        String openid = sessionInfo.get("openid");
        return openid;
    }

    @RequestMapping("saveUserInfo/{token}")
    public void saveUserInfo(@RequestBody UserInfoEntity userInfo, @PathVariable String token) {
        userInfo.setOpenId(sessionService.getOpenId(token));
        weixinService.saveUserInfo(userInfo);
    }
}
