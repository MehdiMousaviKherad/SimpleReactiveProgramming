package com.example.project.Controller;

import com.example.project.Dto.RelationRecord;
import com.example.project.Model.Course;
import com.example.project.Model.Student;
import com.example.project.Model.StudentWithCourses;
import com.example.project.Service.StudentWithCoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/student-course")
public class StudentWithCoursesController {

    @Autowired
    private StudentWithCoursesService service;

    @PostMapping
    public Mono<StudentWithCourses> save(@RequestBody RelationRecord record) {
        return service.save(record.studentId(), record.courseId());

    }

    @GetMapping("/{id}")
    public Flux<Course> getByStudentId(@PathVariable Long id) {
        return service.getCoursesForStudentById(id);
    }

}
