package com.groupeuisi.ParcInfo.service;
import com.groupeuisi.ParcInfo.Repository.*;
import com.groupeuisi.ParcInfo.Mapping.*;
import com.groupeuisi.ParcInfo.Domaine.*;
import com.groupeuisi.ParcInfo.exception.*;


import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Service
@AllArgsConstructor
public class AppRolesService {
    private IroleRepository iAppRolesRepository;
    private IuserRepository iAppUserRepository;
    private RoleMapper appRolesMapper;
    MessageSource messageSource;
    




    @Transactional(readOnly = true)
    public List<AppRolesDTO> getAppRoles() {
     return StreamSupport.stream(iAppRolesRepository.findAll().spliterator(), false)
             .map(appRolesMapper::toAppRoleDTO)
             .collect(Collectors.toList());
    }
    //si on veut recuperer un seul role
    @Transactional(readOnly = true)
    public AppRolesDTO getAppRoles(int id) {//toAppRoles
        return appRolesMapper.toAppRoleDTO(iAppRolesRepository.findById(id)
                .orElseThrow(() ->//on cherche si on trouve on retourn  sinon on vas simplement envoyer saa
                new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{id},
                        Locale.getDefault()))));
    }

    //la partie insertion
    @Transactional
    public AppRolesDTO createAppRole(AppRolesDTO appRoles) {
        //ce qui est dans la parantese c pour l'insertion //toAppRoles    //fromAppRolesDTO
        return appRolesMapper.toAppRoleDTO(iAppRolesRepository.save(appRolesMapper.fromAppRoleDTO(appRoles)));
    }
   //la partie Modification
	/*
	 * @Transactional public AppRolesDTO updateAppRoles(int id, AppRolesDTO
	 * appRoles){ return iAppRolesRepository.findById(id) .map(entity -> {
	 * appRoles.setId(id); //toAppRoles return
	 * appRolesMapper.toAppRoleDTO((iAppRolesRepository.save(appRolesMapper.
	 * fromAppRolesDTO(appRoles)))); }).orElseThrow(() -> new
	 * EntityNotFoundException(messageSource.getMessage("appRoles.notfound", new
	 * Object[]{id}, Locale.getDefault()))); }
	 */
    //la partie suppression
    @Transactional
    public void deleteAppRoles(int id) {
        try {
            iAppRolesRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("appRoels.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
