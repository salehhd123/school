package com.example.school.Controller;

import com.example.school.API.ApiResponse;
import com.example.school.Dto.DetailsDto;
import com.example.school.Service.TeacherDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/teacherDetails")
@RequiredArgsConstructor
public class TeacherDetailsController {


    private final TeacherDetailsService teacherDetailsSer;


    @PostMapping("/add")
    public ResponseEntity added(@RequestBody DetailsDto detailsDto){
        teacherDetailsSer.add(detailsDto);
        ApiResponse response = new ApiResponse<>("added");
        return ResponseEntity.status(200).body(response);
    }

}
