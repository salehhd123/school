package com.example.school.Service;


import com.example.school.Dto.DetailsDto;
import com.example.school.Model.Teacher;
import com.example.school.Model.TeacherDetails;
import com.example.school.Repository.TeacherDetailsRepository;
import com.example.school.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherDetailsService {


    private final TeacherRepository teacherRepository;
    private final TeacherDetailsRepository teacherDetailsRepository;

    public void add(DetailsDto detailsDto){
        Teacher teacher = teacherRepository.findTeacherById(detailsDto.getTeacherId());
        TeacherDetails teacherDetails = new TeacherDetails(null,detailsDto.getAge(), detailsDto.getPhoneNumber(),teacher);
        teacherDetailsRepository.save(teacherDetails);
    }

}
