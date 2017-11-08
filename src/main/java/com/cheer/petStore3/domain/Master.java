/**
 * 
 */
package com.cheer.petStore3.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "tbl_master2")
@Entity
public class Master extends BaseEntity
{
    private String username;

    private String password;

    public Master() {}

    public Master(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return this.username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return this.password;
    }
}
