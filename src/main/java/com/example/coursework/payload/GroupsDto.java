package com.example.coursework.payload;


import com.example.coursework.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupsDto {

    private Integer id;
    private String name;
    private int numOfStudent;
    private String startsAt;
    private String endsAt;
    private Course course;


    public GroupsDto(Integer id, String name, int numOfStudent, String startsAt, String endsAt) {
        this.id = id;
        this.name = name;
        this.numOfStudent = numOfStudent;
        this.startsAt = startsAt;
        this.endsAt = endsAt;
        this.course = course;
    }


    @Override
    public String toString() {
        return "GroupsDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numOfStudent=" + numOfStudent +
                ", startsAt='" + startsAt + '\'' +
                ", endsAt='" + endsAt + '\'' +
                ", course=" + course +
                '}';
    }

}
