package com.example.demo.model;

import com.example.demo.model.base.TimedEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "voter")
public class Voter extends TimedEntity {

    private static final long serialVersionUID = 4508568922188488732L;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @ManyToOne
    @JoinColumn(name = "uik_id")
    private Uik uik;
}
