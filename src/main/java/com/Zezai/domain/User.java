package com.Zezai.domain;

public class User {
   public String username;
    public String password;
    public int leftMoney;
    public User(){}
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLeftMoney() {
        return leftMoney;
    }

    public void setLeftMoney(int leftMoney) {
        this.leftMoney = leftMoney;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id='" + username + '\'' +
                ", Code='" + password + '\'' +
                '}';
    }
}
