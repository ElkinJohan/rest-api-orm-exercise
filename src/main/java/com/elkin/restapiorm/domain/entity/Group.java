package com.elkin.restapiorm.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "groups")
public class Group {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "group")
    private List<Group_Permit> group_permitList;

    //metodos extra...
    public List<Permit> getPermissions(){
        return getGroup_permitList()
                .stream()
                .map(group_permit -> group_permit.getPermit())
                .collect(Collectors.toList());
    }
}
