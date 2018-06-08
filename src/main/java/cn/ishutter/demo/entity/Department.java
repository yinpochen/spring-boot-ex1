package cn.ishutter.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
}
