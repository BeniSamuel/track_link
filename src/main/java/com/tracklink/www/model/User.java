package com.tracklink.www.model;

import com.tracklink.www.enums.Role;

public class User {
    private Long user_id;
    private String name;
    private String email;
    private String password;
    private int phone;
    private Role role;

    public User () {}
    public User (String name, String email, String password, int phone, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
    }

    // Getters and Setters
    public Long getUser_id () { return this.user_id; }
    public String getName () { return this.name; }
    public String getEmail () { return this.email; }
    public String getPassword () { return this.password; }
    public int getPhone () { return this.phone; }
    public Role getRole () { return this.role; }

    public void setUser_id (Long id) { this.user_id = id; }
    public void setName (String name) { this.name = name; }
    public void setEmail (String email) { this.email = email; }
    public void setPassword (String password) { this.password = password; }
    public void setPhone (int phone) { this.phone = phone; }
    public void setRole (Role role) { this.role = role; }
}
