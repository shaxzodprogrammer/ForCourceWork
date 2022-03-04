package com.example.coursework.service;

import com.example.coursework.entity.Groups;
import com.example.coursework.entity.Student;
import com.example.coursework.payload.ApiResponse;
import com.example.coursework.payload.GroupsDto;
import com.example.coursework.payload.StudentDto;
import com.example.coursework.repository.CourseRepository;
import com.example.coursework.repository.GroupsRepository;
import com.example.coursework.repository.StudentRepository;
import com.example.coursework.utills.CommonUtills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    DtoService dtoService;

    public ApiResponse saveOrEditStudent(StudentDto studentDto) {
        try {
            Student student = new Student();
            if (studentDto.getId() != null) {
               student = studentRepository.findById(studentDto.getId())
                        .orElseThrow(() -> new IllegalStateException("Student not found"));
            }
            student.setFirst_name(studentDto.getFirst_name());
            student.setLast_name(studentDto.getLast_name());
            student.setPhone_number(studentDto.getPhone_number());
            studentRepository.save(student);
            return new ApiResponse(studentDto.getId() != null ? "Edited" : "Saved", true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse("Error", false);
        }
    }


    public ApiResponse getAll(Integer page, Integer size) {
        try {
            Page<Student> all = studentRepository
                    .findAll(CommonUtills.getPageableByIdDesc(page, size));
            return new ApiResponse(
                    "Success",
                    true,
                    all.getContent().stream().map(student -> dtoService.getStudentDto(student)).collect(Collectors.toList()),
                    all.getTotalElements(),
                    all.getTotalPages());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return new ApiResponse("Error", false);
        }
    }

    public ApiResponse delete(Integer id){
        try{
          studentRepository.deleteById(id);
            return new ApiResponse("Deleted", true);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse("Error", false);
        }
    }
}
