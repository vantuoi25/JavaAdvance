package com.vti.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Group")
public class Group {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="name", length = 50, nullable = false, unique = true)
    private String name;

    @Column(name ="total_member", columnDefinition = "default 0")
    private int totalMember;

    @Column(name ="creator")
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account creator;





}

