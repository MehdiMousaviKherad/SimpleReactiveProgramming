package com.example.project.Controller;

import com.example.project.Model.Student;
import com.example.project.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping()
    public Mono<ResponseEntity<Student>> save(@RequestBody Student student) {
        return service
                .save(student)
                .map(item -> new ResponseEntity<>(item, HttpStatus.OK))
                .onErrorMap(item -> new NullPointerException());
    }

    @GetMapping
    public Flux<Student> getAll() {
        return service.getAll();
    }

    @PutMapping
    public Mono<Student> update(@RequestBody Student student, @RequestParam Long id) {
        return service.update(student, id);
    }

}
