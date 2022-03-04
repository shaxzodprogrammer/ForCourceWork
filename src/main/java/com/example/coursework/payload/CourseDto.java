package com.example.coursework.payload;

import com.example.coursework.entity.enums.CourceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {

    private Integer id;
    private String subject;
    private CourceType type;
    private int numsOfHours;
    private double fee;


    @Override
    public String toString() {
        return "CourseDto{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", type=" + type +
                ", numsOfHours=" + numsOfHours +
                ", fee=" + fee +
                '}';
    }


}


