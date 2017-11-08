/**
 * 
 */
package com.cheer.petStore3.domain;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "tbl_pet2")
@Entity
public class Pet extends BaseEntity
{
    private String masterUserName;

    private String name;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private PetType petType;

    private int health;

    private int love;

    private Date adoptTime;

    private String status;

    public Pet() {}

    public Pet(String masterUserName, String name, PetType petType, int health, int love,
               Date adoptTime, String status)
    {
        this.masterUserName = masterUserName;
        this.name = name;
        this.petType = petType;
        this.health = health;
        this.love = love;
        this.adoptTime = adoptTime;
        this.status = status;
    }

    public void setMasterUserName(String masterUserName)
    {
        this.masterUserName = masterUserName;
    }

    public String getMasterUserName()
    {
        return this.masterUserName;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setPetType(PetType petType)
    {
        this.petType = petType;
    }

    public PetType getPetType()
    {
        return this.petType;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public int getHealth()
    {
        return this.health;
    }

    public void setLove(int love)
    {
        this.love = love;
    }

    public int getLove()
    {
        return this.love;
    }

    public void setAdoptTime(Date adoptTime)
    {
        this.adoptTime = adoptTime;
    }

    public Date getAdoptTime()
    {
        return this.adoptTime;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return this.status;
    }

}