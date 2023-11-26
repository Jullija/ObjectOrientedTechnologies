package pl.edu.agh.to.school.course;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.agh.to.school.student.Student;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
