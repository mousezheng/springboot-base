package cn.zslstudy.base.Dao;

import cn.zslstudy.base.Entity.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description
 * @ClassName SessionDao
 * @Author User
 * @date 2020.10.11 21:06
 */
public interface SessionRepo extends JpaRepository<SessionEntity, Integer> {

    SessionEntity findOneByToken(String token);

    SessionEntity findOneByOpenId(String openId);
}
