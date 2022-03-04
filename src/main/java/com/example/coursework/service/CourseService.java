package com.example.coursework.service;

import com.example.coursework.entity.Course;
import com.example.coursework.payload.ApiResponse;
import com.example.coursework.payload.CourseDto;
import com.example.coursework.repository.CourseRepository;
import com.example.coursework.utills.CommonUtills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    DtoService dtoService;

    public ApiResponse saveOrEditCourse(CourseDto courseDto) {
        try {
            Course course = new Course();
            if (courseDto.getId() != null) {
                course =courseRepository.findById(courseDto.getId())
                        .orElseThrow(() -> new IllegalStateException("Course not found"));
            }
            course.setSubject(courseDto.getSubject());
            course.setType(courseDto.getType());
            course.setNumsOfHours(courseDto.getNumsOfHours());
            course.setFee(courseDto.getFee());
            courseRepository.save(course);
            return new ApiResponse(courseDto.getId() != null ? "Edited" : "Saved", true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse("Error", false);
        }
    }


    public ApiResponse getAll(Integer page, Integer size) {
        try {
            Page<Course> all = courseRepository
                    .findAll(CommonUtills.getPageableByIdDesc(page, size));
            return new ApiResponse(
                    "Success",
                    true,
                    all.getContent().stream().map(course -> dtoService.getCourseDto(course)).collect(Collectors.toList()),
                    all.getTotalElements(),
                    all.getTotalPages());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return new ApiResponse("Error", false);
        }
    }

    public ApiResponse delete(Integer id){
        try{
           courseRepository.deleteById(id);
            return new ApiResponse("Deleted", true);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse("Error", false);
        }
    }
}
