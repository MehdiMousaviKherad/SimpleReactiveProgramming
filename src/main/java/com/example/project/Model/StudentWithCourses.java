package com.example.project.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "studentwithcourse")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentWithCourses {
    @Id
    private Long id;
    private Long studentId;
    private Long courseId;
}
