package pl.edu.agh.to.school.grade;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.agh.to.school.student.Student;

public interface GradeRepository extends JpaRepository<Grade, Integer> {
}
