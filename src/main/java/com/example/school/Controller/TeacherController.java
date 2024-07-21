package com.example.school.Controller;


import com.example.school.API.ApiResponse;
import com.example.school.Dto.CourseDto;
import com.example.school.Dto.TeacherDto;
import com.example.school.Model.Teacher;
import com.example.school.Model.TeacherDetails;
import com.example.school.Service.CourseService;
import com.example.school.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;



    @GetMapping("/all")
    public ResponseEntity all(){
        return ResponseEntity.status(200).body(teacherService.getAll());
    }


    @PostMapping("/")
    public ResponseEntity add(@RequestBody Teacher teacher){
        teacherService.add(teacher);
        ApiResponse response = new ApiResponse<>("added");
        return ResponseEntity.status(200).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remove(@PathVariable Integer id){
       teacherService.remove(id);
        ApiResponse response = new ApiResponse<>("removed");
        return ResponseEntity.status(200).body(response);
    }

    @PostMapping("/addToAll")
    public ResponseEntity addCoursesAndDetailsWithTeacher(@RequestBody TeacherDto teacherDto){
        teacherService.addCoursesAndDetailsWithTeacher(teacherDto);
        ApiResponse response = new ApiResponse<>("added");
        return ResponseEntity.status(200).body(response);
    }

    @PutMapping("/changeCourses/{id}")
    public ResponseEntity changeTheCourseFromTeacher(@PathVariable Integer id, @RequestBody List<CourseDto> courseDtos){
        teacherService.changeTheCourseFromTeacher(id, courseDtos);
        ApiResponse response = new ApiResponse<>("changed");
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/teachesDto")
    public  ResponseEntity find(){
        return ResponseEntity.status(200).body(teacherService.find());
    }

    @PostMapping("/addTeacherAndCourseWithCheck")
    public ResponseEntity addTeacherAndCourseWithCheck(@RequestBody TeacherDto teacherDto){
        teacherService.addTeacherAndCourseWithCheck(teacherDto);
        ApiResponse response = new ApiResponse<>("added");
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/extraData")
    public  ResponseEntity allExtraData(){
        return ResponseEntity.status(200).body(teacherService.getAllByExtra());
    }

}
