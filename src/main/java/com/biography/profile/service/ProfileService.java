package com.biography.profile.service;

import com.biography.profile.dto.ProfileDTO;

public interface ProfileService {

    ProfileDTO findProfile(final Long id);
}
