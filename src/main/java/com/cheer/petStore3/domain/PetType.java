/**
 * 
 */
package com.cheer.petStore3.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "tbl_petType2")
@Entity
public class PetType extends BaseEntity
{
    @Column
    private String name;

    public PetType() {}

    public PetType(String name)
    {
        this.name = name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }
}
