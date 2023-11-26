package pl.edu.agh.to.school.course;

import jakarta.persistence.*;
import pl.edu.agh.to.school.student.Student;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {

    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    List<Student> studentsOnCourse = new ArrayList<>();



    public Course(String name){
        this.name = name;
    }

    public Course(){}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Student> getStudentsOnCourse() {
        return studentsOnCourse;
    }

    public void setStudentsOnCourse(List<Student> studentsOnCourse) {
        this.studentsOnCourse = studentsOnCourse;
    }


    public void assignStudent(Student student){
        studentsOnCourse.add(student);
    }

    public void removeStudent(Student student){
        studentsOnCourse.remove(student);
    }

}
