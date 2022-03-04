package com.example.coursework.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {

    private Integer id;
    private String first_name;
    private String last_name;
    private String phone_number;
    private String speciality;
    private Integer experience;


    @Override
    public String toString() {
        return "TeacherDto{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", speciality='" + speciality + '\'' +
                ", experience=" + experience +
                '}';
    }
}
