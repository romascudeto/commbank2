package com.alvin.commbank.model;

import javax.persistence.*;


@Entity
@Table(name="users")
public class User {
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String phone;

    public User()
    {

    }
    public User(String name, String phone)
    {
        this.name=name;
        this.phone=phone;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}