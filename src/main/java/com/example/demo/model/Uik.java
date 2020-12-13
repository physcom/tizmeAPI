package com.example.demo.model;

import com.example.demo.model.base.TimedEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "uik")
public class Uik extends TimedEntity {

    private static final long serialVersionUID = 7173681229695394669L;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "tik_id")
    private Tik tik;
}
