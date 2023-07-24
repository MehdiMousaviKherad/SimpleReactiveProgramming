package com.example.project.Repository;

import com.example.project.Model.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface StudentRepository extends ReactiveCrudRepository<Student , Long> {

}
