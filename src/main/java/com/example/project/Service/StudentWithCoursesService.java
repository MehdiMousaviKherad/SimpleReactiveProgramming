package com.example.project.Service;

import com.example.project.Model.Course;
import com.example.project.Model.Student;
import com.example.project.Model.StudentWithCourses;
import com.example.project.Repository.StudentWithCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentWithCoursesService {
    @Autowired
    private StudentWithCoursesRepository repository;
    @Autowired
    private CourseService courseService ;
    public Mono<StudentWithCourses> save(Long StudentID, Long CourseId) {
        var obj = StudentWithCourses.builder()
                .courseId(CourseId)
                .studentId(StudentID)
                .build();
        return repository.save(obj);
    }

    public Flux<StudentWithCourses> getAll() {
        return repository.findAll();
    }
    public Flux<Course> getCoursesForStudentById(Long id){
        return repository.getByStudentId(id)
                .flatMap(item -> courseService.findById(item.getCourseId())) ;
    }
}
