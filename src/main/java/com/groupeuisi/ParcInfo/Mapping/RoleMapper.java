package com.groupeuisi.ParcInfo.Mapping;

import com.groupeuisi.ParcInfo.Domaine.AppRolesDTO;
import com.groupeuisi.ParcInfo.Entity.AppRoleEntity;
import org.mapstruct.Mapper;

@Mapper
public interface RoleMapper {
    AppRolesDTO toAppRoleDTO(AppRoleEntity appRoleEntity);
    AppRoleEntity fromAppRoleDTO(AppRolesDTO appRoleDTO);

}
