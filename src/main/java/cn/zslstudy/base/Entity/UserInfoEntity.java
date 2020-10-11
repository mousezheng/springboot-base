package cn.zslstudy.base.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @Description
 * @ClassName UserInfoEntity
 * @Author User
 * @date 2020.10.11 22:51
 */
@Entity
@Table(name = "user_info", schema = "base")
public class UserInfoEntity{
    private String openId;
    private String userInfo;
    private String nickName;
    private String avatarUrl;
    private String gender;
    private String city;
    private String province;
    private String country;
    private int addTime;
    private String unionId;

    @Id
    @Column(name = "open_id")
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Basic
    @Column(name = "user_info")
    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    @Basic
    @Column(name = "nick_name")
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Basic
    @Column(name = "avatar_url")
    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "province")
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "add_time")
    public int getAddTime() {
        return addTime;
    }

    public void setAddTime(int addTime) {
        this.addTime = addTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfoEntity that = (UserInfoEntity) o;
        return addTime == that.addTime &&
                Objects.equals(openId, that.openId) &&
                Objects.equals(userInfo, that.userInfo) &&
                Objects.equals(nickName, that.nickName) &&
                Objects.equals(avatarUrl, that.avatarUrl) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(city, that.city) &&
                Objects.equals(province, that.province) &&
                Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(openId, userInfo, nickName, avatarUrl, gender, city, province, country, addTime);
    }

    @Column(name = "union_id")
    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }
}
