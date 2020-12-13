package com.example.demo.model;

import com.example.demo.model.base.BaseEntity;
import com.example.demo.model.base.TimedEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "region")
public class Region extends TimedEntity {

    private static final long serialVersionUID = 2725843845213420871L;

    @Column(name = "name")
    private String name;
}
