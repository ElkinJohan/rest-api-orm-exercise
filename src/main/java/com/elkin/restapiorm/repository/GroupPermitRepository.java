package com.elkin.restapiorm.repository;

import com.elkin.restapiorm.domain.entity.Group_Permit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupPermitRepository extends JpaRepository<Group_Permit, Long> {
}
