package com.vti.entity;

import javax.persistence.*;


@Entity
@Table(name = "Group")
public class Group {

    public Group(){

    }
    public Group( String name){
       // this.id = id;
        this.name = name;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "Name", length = 150, nullable = false)
    private String name;

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
