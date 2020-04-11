package com.biography.profile.dto;

import com.biography.profile.model.ProfileEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ProfileDTO {

    private String name;

    private Integer age;

    private String biography;

    private String email;

    private String contact;

    public ProfileDTO(final ProfileEntity profileEntity){
        this.name = profileEntity.getName();
        this.age = profileEntity.getAge();
        this.biography = profileEntity.getBiography();
        this.email = profileEntity.getEmail();
        this.contact = profileEntity.getContact();
    }
}
