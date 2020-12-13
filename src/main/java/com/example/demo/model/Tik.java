package com.example.demo.model;

import com.example.demo.model.base.TimedEntity;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tik")
public class Tik extends TimedEntity {

    private static final long serialVersionUID = -633994445032593795L;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;
}
