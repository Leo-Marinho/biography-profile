package com.biography.profile.service.impl;

import com.biography.profile.dto.ProfileDTO;
import com.biography.profile.exceptions.NotFoundException;
import com.biography.profile.repository.ProfileRepository;
import com.biography.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public ProfileDTO findById(final Long id) {

        return profileRepository.findById(id)
                                .map(ProfileDTO::new)
                                .orElseThrow(() -> new NotFoundException("Id invalido - verifique"));
    }
}
