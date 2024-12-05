package com.elkin.restapiorm.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "groups_permit")
public class Group_Permit {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_group", referencedColumnName = "id", updatable = false, insertable = false)
    private Group group;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_permit", referencedColumnName = "id", updatable = false, insertable = false)
    private Permit permit;

}
