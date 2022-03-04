package com.example.coursework.service;

import com.example.coursework.entity.Course;
import com.example.coursework.entity.Groups;
import com.example.coursework.entity.Student;
import com.example.coursework.payload.CourseDto;
import com.example.coursework.payload.GroupsDto;
import com.example.coursework.payload.StudentDto;
import org.springframework.stereotype.Service;

@Service
public class DtoService {

    public GroupsDto getGroupsDto(Groups groups) {
        GroupsDto dto = new GroupsDto(
                groups.getId(),
                groups.getName(),
                groups.getNumOfStudent(),
                groups.getStartsAt(),
                groups.getEndsAt()
        );
        return dto;
    }

    public CourseDto getCourseDto(Course course) {
        CourseDto dto = new CourseDto(
                course.getId(),
                course.getSubject(),
                course.getType(),
                course.getNumsOfHours(),
                course.getFee()
        );
        return dto;
    }

    public StudentDto getStudentDto(Student student) {
        StudentDto dto = new StudentDto(
                student.getId(),
                student.getFirst_name(),
                student.getLast_name(),
                student.getPhone_number()
        );
        return dto;
    }


}
