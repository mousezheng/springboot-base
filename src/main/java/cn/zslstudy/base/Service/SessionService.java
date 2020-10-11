package cn.zslstudy.base.Service;

import cn.zslstudy.base.Dao.SessionRepo;
import cn.zslstudy.base.Entity.SessionEntity;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Description
 * @ClassName SessionService
 * @Author User
 * @date 2020.10.11 21:22
 */
@Service
public class SessionService {
    @Autowired
    SessionRepo sessionRepo;

    public void save(String token, Map<String, String> sessionInfo) {
        String openId = sessionInfo.get("openid");
        SessionEntity session = sessionRepo.findOneByOpenId(openId);
        if (session == null) {
            session = new SessionEntity();
        }
        session.setToken(token);
        session.setSessionInfo(JSONObject.toJSONString(sessionInfo));
        session.setUpdateTime((int) System.currentTimeMillis());
        session.setOpenId(sessionInfo.get("openid"));
        sessionRepo.save(session);
    }

    public Map<String, String> getSessionInfo(String token) {
        SessionEntity session = sessionRepo.findOneByToken(token);
        return (Map<String, String>) JSONObject.parse(session.getSessionInfo());
    }

    public String getOpenId(String token) {
        return getSessionInfo(token).get("openid");
    }
}
