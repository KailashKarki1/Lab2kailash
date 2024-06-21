package com.example.csd214lab2kailash;

public class mytable {
    private int id;
    private String bank;
    private String username;
    private String password;

    public mytable(int id, String bank, String username, String password) {
        this.id = id;
        this.bank = bank;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

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
}
