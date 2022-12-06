package com.groupeuisi.ParcInfo.Repository;

import com.groupeuisi.ParcInfo.Entity.AppRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IroleRepository extends JpaRepository<AppRoleEntity, Integer> {
}
