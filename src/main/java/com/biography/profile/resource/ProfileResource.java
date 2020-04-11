package com.biography.profile.resource;

import com.biography.profile.dto.ProfileDTO;
import com.biography.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileResource {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/{id}")
    private ProfileDTO searchProfile(final Long id){

       return profileService.findProfile(id);
    }


}
