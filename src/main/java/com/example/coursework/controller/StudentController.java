package com.example.coursework.controller;

import com.example.coursework.payload.ApiResponse;
import com.example.coursework.payload.GroupsDto;
import com.example.coursework.payload.StudentDto;
import com.example.coursework.service.GroupsService;
import com.example.coursework.service.StudentService;
import com.example.coursework.utills.AppConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/student")
public class StudentController {

    @Autowired
   private StudentService studentService;

    @PostMapping("saveOrEditGroup")
    public HttpEntity<?> saveOrEditGroup(@RequestBody StudentDto studentDto) {
        ApiResponse response = studentService.saveOrEditGroup(studentDto);
        return ResponseEntity.status(response.isSuccess() ?
                response.getMessage().equals("Edited") ? 202 : 201 : 409)
                .body(response);
    }

    @GetMapping("/getAll")
    public HttpEntity<?> getall(@RequestParam(value = "page",defaultValue = AppConst.PAGE_DEFAULT_NUMBER)Integer page,
                             @RequestParam(value = "size",defaultValue = AppConst.PAGE_DEFAULT_SIZE)Integer size) throws IllegalAccessException {
        ApiResponse response = studentService.getAll(page,size);
        return ResponseEntity.status(response.isSuccess()?200:409).body(response);
    }



    @GetMapping("/delete/{id}")
    public HttpEntity<?> delete(@PathVariable("id") Integer id) {
        ApiResponse apiResponse = studentService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

}
