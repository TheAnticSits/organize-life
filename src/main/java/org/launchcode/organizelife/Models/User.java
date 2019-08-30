package org.launchcode.organizelife.Models;

import org.springframework.boot.autoconfigure.domain.EntityScan;


public class User {

    private String userName;
    private String email;
    private String password;
    private String passwordVerify;


    public User(String userName, String email, String password, String passwordVerify) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.passwordVerify = passwordVerify;


    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordVerify() {
        return passwordVerify;
    }

    public void setPasswordVerify(String passwordVerify) {
        this.passwordVerify = passwordVerify;
    }

}
