package com.biography.profile.factory;

import com.biography.profile.model.ProfileEntity;
import org.springframework.stereotype.Component;

@Component
public class ProfileFactory implements Factory<ProfileEntity> {

    @Override
    public ProfileEntity createDefault() {
        return ProfileEntity.builder()
                    .id(1L)
                    .name("admin")
                    .contact("62981711706")
                    .email("test@test.com")
                    .biography("biography")
                    .age(18)
                .build();
    }

    @Override
    public ProfileEntity createEmpty() {
        return new ProfileEntity();
    }
}
