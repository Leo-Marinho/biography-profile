package com.biography.profile.resource;

import com.biography.profile.integration.client.model.CourseDTO;
import com.biography.profile.dto.ProfileDTO;
import com.biography.profile.integration.client.CourseClient;
import com.biography.profile.resource.request.ProfileRequest;
import com.biography.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileResource {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private CourseClient courseClient;

    @GetMapping("/{id}")
    private ProfileDTO searchProfile(@PathVariable final Long id){

       return profileService.findById(id);
    }

    @GetMapping("/courses/{name}")
    private List<CourseDTO> getCourses(@PathVariable final String name){

        return courseClient.getCourse(name);
    }

    @PutMapping("/{id}")
    private ProfileDTO update(@PathVariable Long id, @RequestBody ProfileRequest request){

        final ProfileDTO profileDTO = request.toDTO();
        return profileService.update(id, profileDTO);
    }
}
