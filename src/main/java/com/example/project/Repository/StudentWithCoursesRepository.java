package com.example.project.Repository;

import com.example.project.Model.StudentWithCourses;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface StudentWithCoursesRepository extends ReactiveCrudRepository<StudentWithCourses, Long> {

     Flux<StudentWithCourses> getByStudentId(Long studentId);


}
