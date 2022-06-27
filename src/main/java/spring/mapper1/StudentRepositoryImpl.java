package spring.mapper1;

import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class StudentRepositoryImpl implements StudentRepository{
    private Map<Long, Student> map = new HashMap<>();
    private List<Student> list = new ArrayList<>();
    private static long sequence = 0L;

    @Override
    public Student save(Student student) {
        student.setStudentId(sequence++);
        map.put(student.getStudentId(),student);
        list.add(map.get(student.getStudentId()));
        return student;
    }

    @Override
    public Optional<Student> findById(long studentId) {
        Optional<Student> student= Optional.ofNullable(map.get(studentId));
        return student;
    }

    @Override
    public Optional<Student> findByName(String name) {

        for(long i : map.keySet()) {
            if(name.equals(map.get(i).getName())) {

                return Optional.ofNullable(map.get(i));
            }

        }

        return Optional.empty();
    }

    @Override
    public List<Student> findAll() {

        list.add(new Student(1L, "John",Grade.SECOND));
        list.add(new Student(2L, "James",Grade.FIRST));
        list.add(new Student(3L, "peter",Grade.THRID));
        for(long i : map.keySet()) {
            list.add(map.get(i));
        }
        return list;
    }
}
