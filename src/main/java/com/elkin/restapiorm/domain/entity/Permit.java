package com.elkin.restapiorm.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "permissions")
public class Permit {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "permit")
    private List<Group_Permit> group_permitList;

    //metodos extra...
    public List<Group> getGroups(){
        return getGroup_permitList()
                .stream()
                .map(group_permit -> group_permit.getGroup())
                .collect(Collectors.toList());
    }
}
