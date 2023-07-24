package com.example.project.Service;

import com.example.project.Model.Student;
import com.example.project.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.net.ssl.SSLEngineResult;

@Service
@RequiredArgsConstructor
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public Mono<Student> save(Student student) {
        if (student.getName().isBlank() || student.getName() == null) {
            return Mono.error(NullPointerException::new);
        }
        if (student.getLastname().isBlank() || student.getLastname() == null) {
            return Mono.error(NullPointerException::new);
        }
        return repository.save(student);
    }

    public Flux<Student> getAll() {
        return repository.findAll();
    }

    public Mono<Student> getById(Long id) {
        return repository.findById(id);
    }

    public Mono<Student> update(Student newStudent, Long id) {
        return repository.findById(id)
                .flatMap(item -> {
                    if (item != null) {
                        newStudent.setId(item.getId());
                        return save(newStudent);
                    }
                    return save(newStudent);
                });

    }
}
