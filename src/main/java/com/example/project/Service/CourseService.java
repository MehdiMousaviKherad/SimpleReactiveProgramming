package com.example.project.Service;

import com.example.project.Model.Course;
import com.example.project.Repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CourseService {
    @Autowired
    private CourseRepository courseRepository ;

    public Mono<Course> save(Course course){
        return courseRepository.save(course);
    }
    public Flux<Course> getAll(){
        return courseRepository.findAll();
    }
    public Mono<Course> findById(Long id){
        return courseRepository.findById(id);
    }
}
