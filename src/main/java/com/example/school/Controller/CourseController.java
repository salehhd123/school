package com.example.school.Controller;

import com.example.school.API.ApiResponse;
import com.example.school.Model.Course;
import com.example.school.Service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {


    private final CourseService courseService;


    @GetMapping("/all")
    public ResponseEntity getALl() {
        return ResponseEntity.status(200).body(courseService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Course course) {
        courseService.Add(course);
        ApiResponse response = new ApiResponse<>("added");
        return ResponseEntity.status(200).body(response);
    }

    @PutMapping("/addTeacher/{teacherId}/{CourseId}")
    public ResponseEntity addTeacher(@PathVariable Integer teacherId, @PathVariable Integer CourseId) {
        courseService.addToTeacher(teacherId, CourseId);
        ApiResponse response = new ApiResponse<>("added");
        return ResponseEntity.status(200).body(response);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        courseService.delete(id);
        ApiResponse response = new ApiResponse<>("removed");
        return ResponseEntity.status(200).body(response);
    }

@GetMapping("/findByName/{name}")
    public Course findByName(@PathVariable String name){
        return courseService.findByName(name);
}
}
