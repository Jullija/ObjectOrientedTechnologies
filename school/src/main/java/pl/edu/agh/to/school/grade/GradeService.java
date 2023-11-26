package pl.edu.agh.to.school.grade;

import org.springframework.stereotype.Service;
import pl.edu.agh.to.school.student.Student;
import pl.edu.agh.to.school.student.StudentRepository;

import java.util.List;
@Service
public class GradeService {
    private final GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository){
        this.gradeRepository = gradeRepository;
    }
    public List<Grade> getGrades(){
        return gradeRepository.findAll();
    }
}
