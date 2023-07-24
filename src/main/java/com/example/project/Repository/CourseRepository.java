package com.example.project.Repository;

import com.example.project.Model.Course;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends ReactiveCrudRepository<Course , Long> {
}
