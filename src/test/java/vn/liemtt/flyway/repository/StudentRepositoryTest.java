package vn.liemtt.flyway.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import vn.liemtt.flyway.model.Student;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void addNewStudentTesting() {
        Student student = new Student(1L, "John");

        studentRepository.save(student);

        Optional<Student> studentRepositoryById = studentRepository.findById(1L);

        if(studentRepositoryById.isPresent()) {
            assertEquals(studentRepositoryById.get(), student);
        }
    }
}
