package spring.mapper1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final StudentService studentService;

    public StudentController(StudentRepository studentRepository, StudentMapper studentMapper, StudentService studentService) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.studentService = studentService;
    }
    @PostMapping
    public ResponseEntity saveStudent(@RequestBody StudentPostDto studentPostDto) {
        Student student = studentMapper.studentPostDtoToStudent(studentPostDto);
        Student response = studentService.save(student);
        return new ResponseEntity<>(studentMapper.studentToStudentResponseDto(response), HttpStatus.CREATED);
    }
    @PatchMapping("v1/{student-id}")
    public ResponseEntity patchStudent(@PathVariable ("student-id")long studentId,
                                    @RequestBody StudentPatchDto studentPatchDto) {
        Student student = studentMapper.studentPatchDtoToStudent(studentPatchDto);
        Student response = studentService.save(student);
        return new ResponseEntity<>(studentMapper.studentToStudentResponseDto(response),HttpStatus.OK);
    }
    @GetMapping("/{student-id}")
    public ResponseEntity findstudent(@PathVariable("student-id")long studentId) {
        Student response = studentService.findById(studentId);
        return new ResponseEntity<>(studentMapper.studentToStudentResponseDto(response),HttpStatus.OK);
    }
    @GetMapping("/name/{student-name}")
    public ResponseEntity findStudentByName(@PathVariable("student-name")String name) {
        Student response = studentService.findByname(name);
        return new ResponseEntity<>(studentMapper.studentToStudentResponseDto(response),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity findStudents() {
        List<Student> list = studentService.findAll();
        List<StudentResponseDto> response = list.stream()
                .map(i->studentMapper.studentToStudentResponseDto(i))
                .collect(Collectors.toList());
        return new ResponseEntity(list, HttpStatus.OK);
    }
}
