package com.bean;

public class User {
    private String name ;
    private  String gendere;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", gendere='" + gendere + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGendere() {
        return gendere;
    }

    public void setGendere(String gendere) {
        this.gendere = gendere;
    }
}
