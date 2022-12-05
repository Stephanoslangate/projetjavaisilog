package com.groupeuisi.ParcInfo.Mapping;

import com.groupeuisi.ParcInfo.Domaine.AppRoleDTO;
import com.groupeuisi.ParcInfo.Entity.AppRoleEntity;
import org.mapstruct.Mapper;

@Mapper
public interface RoleMapper {
    AppRoleDTO toAppRoleDTO(AppRoleEntity appRoleEntity);
    AppRoleEntity fromAppRoleDTO(AppRoleDTO appRoleDTO);

}
