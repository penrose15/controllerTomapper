package spring.mapper1;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student save(Student student) {
        return studentRepository.save(student);
    }
    public Student findById(long studentId) {
        Optional<Student> student =studentRepository.findById(studentId);
        return student.get();
    }

    public Student findByname(String name) {
        Optional<Student> student = studentRepository.findByName(name);
        return student.get();
    }
    public List<Student> findAll() {
       return studentRepository.findAll();
    }
}
