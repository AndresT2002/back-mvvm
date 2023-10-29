package com.udea.mvvc.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="to_do")
@Getter
@Setter
@NoArgsConstructor
public class ToDoEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="status")
    private Boolean status;

    @Column(name="date")
    private Date date;

}
