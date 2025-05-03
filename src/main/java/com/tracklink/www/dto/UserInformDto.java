package com.tracklink.www.dto;

import com.tracklink.www.enums.Role;

public class UserInformDto {
    private String name;
    private String email;
    private String password;
    private int phone;
    private Role role;

    public String getName () { return this.name; }
    public String getEmail () { return this.email; }
    public String getPassword () { return this.password; }
    public int getPhone () { return this.phone; }
    public Role getRole () { return this.role; }
}
