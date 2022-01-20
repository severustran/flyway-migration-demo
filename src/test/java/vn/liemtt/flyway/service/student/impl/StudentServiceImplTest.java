package vn.liemtt.flyway.service.student.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import vn.liemtt.flyway.model.Student;
import vn.liemtt.flyway.repository.StudentRepository;
import vn.liemtt.flyway.service.student.StudentService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;
//    private AutoCloseable closeable;
    private StudentService studentService;

    @BeforeEach
    void setUp() {
//        closeable = MockitoAnnotations.openMocks(this);
        studentService = new StudentServiceImpl(studentRepository);
    }

//    @AfterEach
//    void tearDown() throws Exception {
//        closeable.close();
//    }

    @Test
    void getAllStudents() {
        studentService.getAllStudents();
        verify(studentRepository).findAll();
    }

    @Test
    void addStudentTest() {
        Student student = new Student(2L, "Harry");
        studentService.addStudent(student);

        ArgumentCaptor<Student> argumentCaptor = ArgumentCaptor.forClass(Student.class);
        verify(studentRepository).save(argumentCaptor.capture());

        Student captureStudent = argumentCaptor.getValue();
        assertThat(captureStudent).isEqualTo(student);
    }
}
