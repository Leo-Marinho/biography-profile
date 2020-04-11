package com.biography.profile.service;

import com.biography.profile.dto.ProfileDTO;

public interface ProfileService {

    ProfileDTO findById(final Long id);

    ProfileDTO update(final Long id,final ProfileDTO request);
}
