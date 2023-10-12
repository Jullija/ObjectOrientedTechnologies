package pl.edu.agh.iisg.to.dao;

import java.util.*;

import pl.edu.agh.iisg.to.model.Course;
import pl.edu.agh.iisg.to.model.Grade;
import pl.edu.agh.iisg.to.model.Student;

import javax.persistence.PersistenceException;

public class StudentDao extends GenericDao<Student> {

    public Optional<Student> create(final String firstName, final String lastName, final int indexNumber) {
        try{
            Student student = save(new Student(firstName, lastName, indexNumber));
            return Optional.of(student);
        }catch(PersistenceException e){
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public Optional<Student> findByIndexNumber(final int indexNumber) {
        try{
            return currentSession().createQuery("SELECT s FROM Student s WHERE s.indexNumber = :indexNumber", Student.class)
                    .setParameter("indexNumber", indexNumber).uniqueResultOptional();
        }catch(PersistenceException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Map<Course, Float> createReport(final Student student) {
        CourseDao courseDao = new CourseDao();
        Map<Course, Float> gradeMap = new HashMap<>();
        Set<Grade> gradeSet = student.gradeSet();

        for (Grade grade : gradeSet){
            Course course = courseDao.findById(grade.course().id()).get();
            if (gradeMap.containsKey(course)){
                gradeMap.put(course, (gradeMap.get(course) + grade.grade()) / 2);
            }else{
                gradeMap.put(course, grade.grade());
            }

        }
        return gradeMap;
    }

}
