package pl.edu.agh.to.school.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.edu.agh.to.school.course.Course;
import pl.edu.agh.to.school.course.CourseRepository;
import pl.edu.agh.to.school.grade.Grade;
import pl.edu.agh.to.school.grade.GradeRepository;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfigurator {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, CourseRepository courseRepository, GradeRepository gradeRepository){
        return args -> {
            if (studentRepository.count() == 0){
                Student kowalski = new Student("Jan", "Kowalski", LocalDate.now(), "123456");
                Student zielinski = new Student("Piotr", "Zieliński", LocalDate.now(), "987654");
                Student swirkabazantka = new Student("Świrka", "Bażantka", LocalDate.now(), "192836");

                Course matematyka = new Course("matematyka");
                Course polski = new Course("polski");
                Course informatyka = new Course("informatyka");

                List<Grade> kowalskiGrades = List.of(new Grade(4, matematyka), new Grade(5, matematyka), new Grade(5, informatyka));
                kowalskiGrades.forEach(kowalski::giveGrade);

                List<Grade> zielinskiiGrades = List.of(new Grade(4, polski), new Grade(5, matematyka), new Grade(2, informatyka));
                zielinskiiGrades.forEach(zielinski::giveGrade);

                List<Grade> bazantkaGrades = List.of(new Grade(4, polski), new Grade(5, matematyka), new Grade(5, informatyka));
                bazantkaGrades.forEach(swirkabazantka::giveGrade);

                courseRepository.saveAll(List.of(matematyka, polski, informatyka));

                gradeRepository.saveAll(kowalskiGrades);
                gradeRepository.saveAll(zielinskiiGrades);
                gradeRepository.saveAll(bazantkaGrades);

                studentRepository.saveAll(List.of(kowalski, zielinski, swirkabazantka));

            }
        };
    }
}
