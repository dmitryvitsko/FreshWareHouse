package org.example;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private String position;
    private String create_at;
    private String update_at;
    private Boolean isDriver;
    private String phone;
    private String personalNumber;
    private String categoryInTm;


    public User(int id, String name, String email, String password, String position, String create_at, String update_at, Boolean isDriver, String phone, String personalNumber, String categoryInTm) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.position = position;
        this.create_at = create_at;
        this.update_at = update_at;
        this.isDriver = isDriver;
        this.phone = phone;
        this.personalNumber = personalNumber;
        this.categoryInTm = categoryInTm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getUptate_at() {
        return update_at;
    }

    public void setUptate_at(String uptate_at) {
        this.update_at = uptate_at;
    }

    public Boolean getDriver() {
        return isDriver;
    }

    public void setDriver(Boolean driver) {
        isDriver = driver;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getCategoryInTm() {
        return categoryInTm;
    }

    public void setCategoryInTm(String categoryInTm) {
        this.categoryInTm = categoryInTm;
    }
}