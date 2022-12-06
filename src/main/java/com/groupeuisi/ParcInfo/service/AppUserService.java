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

@Service
@AllArgsConstructor
public class AppUserService {
    private IuserRepository iAppUserRepository;
    private IroleRepository iAppRolesRepository;
    private UserMapper appUserMapper;
    MessageSource messageSource;




    @Transactional(readOnly = true)
    public List<AppUserDTO> getAppUser() {
        return StreamSupport.stream(iAppUserRepository.findAll().spliterator(), false)
                .map(appUserMapper::toAppUserDTO) //toAppUser
                .collect(Collectors.toList());
    }
    //si on veut recuperer un seul role
    @Transactional(readOnly = true)
    public AppUserDTO getAppRoles(int id) {//toAppUser
        return appUserMapper.toAppUserDTO(iAppUserRepository.findById(id)
                .orElseThrow(() ->//on cherche si on trouve on retourn  sinon on vas simplement envoyer saa
                        new EntityNotFoundException(messageSource.getMessage("user.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }

    //la partie insertion 
    @Transactional
    public AppUserDTO createAppRoleUser(AppUserDTO appUserDTO) {
        //ce qui est dans la parantese c pour l'insertion
        //toAppUser
    	return appUserMapper.toAppUserDTO(iAppUserRepository.save(appUserMapper.fromAppUserDTO(appUserDTO)));
    }
    //la partie Modification
	/*
	 * @Transactional public AppUserDTO updateAppUser(int id, AppUserDTO
	 * appUserDTO){ return iAppUserRepository.findById(id) .map(entity -> {
	 * appUserDTO.setId(id); return
	 * appUserMapper.toAppUser((iAppUserRepository.save(appUserMapper.fromAppUserDTO
	 * (appUserDTO)))); }).orElseThrow(() -> new
	 * EntityNotFoundException(messageSource.getMessage("appUser.notfound", new
	 * Object[]{id}, Locale.getDefault()))); }
	 */
    //la partie suppression
    @Transactional
    public void deleteAppRoles(int id) {
        try {
            iAppUserRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("appUser.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
