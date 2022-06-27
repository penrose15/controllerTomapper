package spring.mapper1;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface StudentRepository {
    Student save(Student student);
    Optional<Student> findById(long studentId);
    Optional<Student> findByName(String name);
    List<Student> findAll();

}
