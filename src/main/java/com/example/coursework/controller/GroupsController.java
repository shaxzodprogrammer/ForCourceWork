package com.example.coursework.controller;

import com.example.coursework.payload.ApiResponse;
import com.example.coursework.payload.GroupsDto;
import com.example.coursework.service.GroupsService;
import com.example.coursework.utills.AppConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/group")
public class GroupsController {

    @Autowired
   private GroupsService groupsService;

    @PostMapping("saveOrEditGroup")
    public HttpEntity<?> saveOrEditGroup(@RequestBody GroupsDto groupsDto) {
        ApiResponse response = groupsService.saveOrEditGroup(groupsDto);
        return ResponseEntity.status(response.isSuccess() ?
                response.getMessage().equals("Edited") ? 202 : 201 : 409)
                .body(response);
    }

    @GetMapping("/getAll")
    public HttpEntity<?> getall(@RequestParam(value = "page",defaultValue = AppConst.PAGE_DEFAULT_NUMBER)Integer page,
                             @RequestParam(value = "size",defaultValue = AppConst.PAGE_DEFAULT_SIZE)Integer size) throws IllegalAccessException {
        ApiResponse response = groupsService.getAll(page,size);
        return ResponseEntity.status(response.isSuccess()?200:409).body(response);
    }



    @GetMapping("/delete/{id}")
    public HttpEntity<?> delete(@PathVariable("id") Integer id) {
        ApiResponse apiResponse = groupsService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

}
