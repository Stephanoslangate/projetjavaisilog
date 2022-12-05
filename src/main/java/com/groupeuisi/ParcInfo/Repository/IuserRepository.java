package com.groupeuisi.ParcInfo.Repository;

import com.groupeuisi.ParcInfo.Entity.AppUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IuserRepository  extends JpaRepository<AppUserEntity, Integer> {
    AppUserEntity findByEmail(String email);

}
