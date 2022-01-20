package vn.liemtt.flyway.service.student.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.liemtt.flyway.model.Student;
import vn.liemtt.flyway.repository.StudentRepository;
import vn.liemtt.flyway.service.student.StudentService;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void addStudent(final Student student) {
        studentRepository.save(student);
    }
}
