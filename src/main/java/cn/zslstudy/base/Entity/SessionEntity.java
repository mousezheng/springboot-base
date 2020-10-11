package cn.zslstudy.base.Entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Description
 * @ClassName SessionEntity
 * @Author User
 * @date 2020.10.11 22:12
 */
@Entity
@Table(name = "session", schema = "base")
public class SessionEntity {
    private int id;
    private String token;
    private String sessionInfo;
    private Integer updateTime;
    private String openId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Basic
    @Column(name = "session_info")
    public String getSessionInfo() {
        return sessionInfo;
    }

    public void setSessionInfo(String sessionInfo) {
        this.sessionInfo = sessionInfo;
    }

    @Basic
    @Column(name = "update_time")
    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "open_id")
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionEntity that = (SessionEntity) o;
        return id == that.id &&
                Objects.equals(token, that.token) &&
                Objects.equals(sessionInfo, that.sessionInfo) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(openId, that.openId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, token, sessionInfo, updateTime, openId);
    }
}
