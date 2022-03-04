package com.example.coursework.service;

import com.example.coursework.entity.Groups;
import com.example.coursework.payload.ApiResponse;
import com.example.coursework.payload.GroupsDto;
import com.example.coursework.repository.CourseRepository;
import com.example.coursework.repository.GroupsRepository;
import com.example.coursework.utills.CommonUtills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class GroupsService {
    @Autowired
    GroupsRepository groupsRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    DtoService dtoService;

    public ApiResponse saveOrEditGroup(GroupsDto groupsDto) {
        try {
            Groups groups = new Groups();
            if (groupsDto.getId() != null) {
                groups = groupsRepository.findById(groupsDto.getId())
                        .orElseThrow(() -> new IllegalStateException("Group not found"));
            }
            groups.setName(groupsDto.getName());
            groups.setNumOfStudent(groupsDto.getNumOfStudent());
            groups.setStartsAt(groupsDto.getStartsAt());
            groups.setEndsAt(groupsDto.getEndsAt());
//            Course course = courseRepository.getById(groupsDto.getCourse().getId());
//            groups.setCourse(new
//                    HashSet<>(Collections.singletonList(
//                            courseRepository.findCoursesById(
//                                    groupsDto.getId()))));
            groupsRepository.save(groups);
            return new ApiResponse(groupsDto.getId() != null ? "Edited" : "Saved", true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse("Error", false);
        }
    }


    public ApiResponse getAll(Integer page, Integer size) {
        try {
            Page<Groups> all = groupsRepository
                    .findAll(CommonUtills.getPageableByIdDesc(page, size));
            return new ApiResponse(
                    "Success",
                    true,
                    all.getContent().stream().map(groups -> dtoService.getGroupsDto(groups)).collect(Collectors.toList()),
                    all.getTotalElements(),
                    all.getTotalPages());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return new ApiResponse("Error", false);
        }
    }

    public ApiResponse delete(Integer id){
        try{
           groupsRepository.deleteById(id);
            return new ApiResponse("Deleted", true);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse("Error", false);
        }
    }
}
