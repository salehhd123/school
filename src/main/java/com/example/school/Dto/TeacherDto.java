package com.example.school.Dto;

import com.example.school.Model.Course;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDto {
    private String firstName;
    private String lastName;
    @Min(value = 0 ,message = "can not be less then zero")
    private Integer age;
    @Pattern(regexp = "05\\d{7}", message = "phone number must start with '05' and be followed by 7 digits")
    private String phoneNumber;
    private List<CourseDto> courses;

}
