package com.biography.profile.resource.request;

import com.biography.profile.dto.ProfileDTO;
import lombok.Data;

@Data
public class ProfileRequest {

    private String name;

    private Integer age;

    private String biography;

    private String email;

    private String contact;

    public ProfileDTO toDTO(){
        return new ProfileDTO(name, age, biography, email, contact);
    }
}
