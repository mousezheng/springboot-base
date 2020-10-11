package cn.zslstudy.base.Dao;

import cn.zslstudy.base.Entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description
 * @ClassName SessionDao
 * @Author User
 * @date 2020.10.11 21:06
 */
public interface UserInfoRepo extends JpaRepository<UserInfoEntity, Integer> {

    UserInfoEntity findOneByOpenId(String openId);
}
