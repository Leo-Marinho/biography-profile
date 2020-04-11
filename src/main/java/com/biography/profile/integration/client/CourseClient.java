package com.biography.profile.integration.client;

import com.biography.profile.integration.client.model.CourseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("biography-course")
public interface CourseClient {

    @RequestMapping("/course/{name}")
    List<CourseDTO> getCourse(@PathVariable String name );
}
