package com.example.project.Controller;

import com.example.project.Model.Course;
import com.example.project.Model.Student;
import com.example.project.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "api/v1/course")
public class CourseController {

    @Autowired
    private CourseService service;

    @PostMapping
    public Mono<Course> save(@RequestBody Course course) {
        return service.save(course);

    }

    @GetMapping()
    public Flux<Course> getAll() {
        return service.getAll();
    }
}
