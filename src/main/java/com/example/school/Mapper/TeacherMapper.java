package com.example.school.Mapper;


import com.example.school.Dto.TeacherDto;
import com.example.school.Model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    @Mapping(source = "teacherDetails.age", target = "age")
    @Mapping(source = "teacherDetails.phoneNumber", target = "phoneNumber")
    TeacherDto teacherToTeacherDto(Teacher teacher);

    List<TeacherDto> teachersToTeacherDtos(List<Teacher> teachers);

}
