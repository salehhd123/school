package com.example.school.Dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DetailsDto {
    private Integer teacherId;
    @NotBlank(message = "age can not be empty!")
    @Min(value = 0 ,message = "can not be less then zero")
    private Integer age;
    @Pattern(regexp = "05\\d{7}", message = "phone number must start with '05' and be followed by 7 digits")
    private String phoneNumber;
}
