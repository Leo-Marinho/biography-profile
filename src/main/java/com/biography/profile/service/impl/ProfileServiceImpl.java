package com.biography.profile.service.impl;

import com.biography.profile.dto.ProfileDTO;
import com.biography.profile.exceptions.NotFoundException;
import com.biography.profile.repository.ProfileRepository;
import com.biography.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public ProfileDTO findProfile(final Long id) {

        return profileRepository.findById(id)
                .map(ProfileDTO::new)
                .orElseThrow(() -> new NotFoundException("Id invalido - verifique"));
    }
}
