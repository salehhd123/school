package com.example.school.Controller;


import com.example.school.API.ApiResponse;
import com.example.school.Dto.LoginDto;
import com.example.school.Model.UserCredential;
import com.example.school.Service.UserCredentialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/userCredentials")
@RequiredArgsConstructor
public class UserCredentialController {

    private final UserCredentialService userCredentialService;


    @GetMapping("/login")
    public ResponseEntity login(@RequestBody LoginDto loginDto){
        userCredentialService.login(loginDto.getEmail(), loginDto.getPassword());
        ApiResponse response = new ApiResponse<>("Login successful");
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/logout/{id}")
    public ResponseEntity logout(@PathVariable Integer id){
        userCredentialService.logout(id);
        ApiResponse response = new ApiResponse<>("Logout successful");
        return ResponseEntity.status(200).body(response);
    }

    @PostMapping("/createAccount")
    public ResponseEntity createAccount(@RequestBody UserCredential userCredential){
        userCredentialService.createUser(userCredential);
        ApiResponse response = new ApiResponse<>("account created");
        return ResponseEntity.status(200).body(response);
    }



}
