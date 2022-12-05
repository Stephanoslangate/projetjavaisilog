package com.groupeuisi.ParcInfo.Mapping;

import com.groupeuisi.ParcInfo.Domaine.AppUserDTO;
import com.groupeuisi.ParcInfo.Entity.AppUserEntity;
import org.mapstruct.Mapper;


@Mapper
public interface UserMapper {
    AppUserDTO toAppUserDTO(AppUserEntity appUserEntity);
    AppUserEntity fromAppUserDTO(AppUserDTO appUserDTO);
}
