package com.biography.profile.dto;

import com.biography.profile.model.ProfileEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

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

    public static List<ProfileDTO> listToDTO(final List<ProfileEntity> profileEntityList){

        return profileEntityList.stream().map(ProfileDTO::new).collect(Collectors.toList());
    }
}
