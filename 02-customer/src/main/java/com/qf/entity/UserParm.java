package com.qf.entity;

/**
 * @author zxp
 * @create 2020-09-10 12:50
 */
public class UserParm {
    public UserParm(){
        super();
    }
    private Integer uid;//主键
    private String username;//用户名

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public  String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserParm(Integer uid, String username) {
        this.uid = uid;
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserParm{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}