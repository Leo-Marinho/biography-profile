package com.biography.profile.service.impl;

import com.biography.profile.dto.ProfileDTO;
import com.biography.profile.exceptions.NotFoundException;
import com.biography.profile.model.ProfileEntity;
import com.biography.profile.repository.ProfileRepository;
import com.biography.profile.service.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public ProfileDTO findById(final Long id) {

        log.info("M=getting Profile - Buscando Perfil");

        return profileRepository.findById(id)
                .map(ProfileDTO::new)
                .orElseThrow(() -> new NotFoundException("Id invalido - Digite novamente"));

    }

    @Override
    public ProfileDTO update(final Long id, final ProfileDTO profileDTO) {
        log.info("M=updating Profile - atualizando perfil");

        final ProfileEntity profileSave = profileRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id inexistente"));

        BeanUtils.copyProperties(profileDTO, profileSave,"id");

        return profileSave.toDTO();
    }
}
