package com.example.coursework.controller;

import com.example.coursework.payload.ApiResponse;
import com.example.coursework.payload.CourseDto;
import com.example.coursework.service.CourseService;
import com.example.coursework.utills.AppConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/course")
public class CourseController {

    @Autowired
   private CourseService courseService;

    @PostMapping("saveOrEditCourse")
    public HttpEntity<?> saveOrEditCourse(@RequestBody CourseDto courseDto) {
        ApiResponse response = courseService.saveOrEditCourse(courseDto);
        return ResponseEntity.status(response.isSuccess() ?
                response.getMessage().equals("Edited") ? 202 : 201 : 409)
                .body(response);
    }

    @GetMapping("/getAll")
    public HttpEntity<?> all(@RequestParam(value = "page",defaultValue = AppConst.PAGE_DEFAULT_NUMBER)Integer page,
                             @RequestParam(value = "size",defaultValue = AppConst.PAGE_DEFAULT_SIZE)Integer size) throws IllegalAccessException {
        ApiResponse response = courseService.getAll(page,size);
        return ResponseEntity.status(response.isSuccess()?200:409).body(response);
    }



    @GetMapping("/delete/{id}")
    public HttpEntity<?> remove(@PathVariable("id") Integer id) {
        ApiResponse apiResponse = courseService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

}
