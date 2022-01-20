package vn.liemtt.flyway.service.student;

import vn.liemtt.flyway.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    void addStudent(Student student);
}
