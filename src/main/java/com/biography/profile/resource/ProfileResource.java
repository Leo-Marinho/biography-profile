package com.biography.profile.resource;

import com.biography.profile.integration.client.model.CourseDTO;
import com.biography.profile.dto.ProfileDTO;
import com.biography.profile.integration.client.CourseClient;
import com.biography.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileResource {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private CourseClient courseClient;

    @GetMapping("/profile/{id}")
    private ProfileDTO searchProfile(final Long id){

       return profileService.findById(id);
    }

    @GetMapping("/{name}")
    private List<CourseDTO> getCourses(@PathVariable String name){

        return courseClient.getCourse(name);
    }
}
