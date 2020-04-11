package com.biography.profile.service;

import com.biography.profile.dto.ProfileDTO;

public interface ProfileService {

    ProfileDTO findById(final Long id);
}
