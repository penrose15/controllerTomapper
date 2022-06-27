package spring.mapper1;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-28T00:21:14+0900",
    comments = "version: 1.5.1.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student studentPostDtoToStudent(StudentPostDto studentPostDto) {
        if ( studentPostDto == null ) {
            return null;
        }

        Student student = new Student();

        student.setStudentId( studentPostDto.getStudentId() );
        student.setName( studentPostDto.getName() );
        student.setGrade( studentPostDto.getGrade() );

        return student;
    }

    @Override
    public Student studentPatchDtoToStudent(StudentPatchDto studentPatchDto) {
        if ( studentPatchDto == null ) {
            return null;
        }

        Student student = new Student();

        student.setStudentId( studentPatchDto.getStudentId() );
        student.setName( studentPatchDto.getName() );
        student.setGrade( studentPatchDto.getGrade() );

        return student;
    }

    @Override
    public StudentResponseDto studentToStudentResponseDto(Student student) {
        if ( student == null ) {
            return null;
        }

        long studentId = 0L;
        String name = null;
        Grade grade = null;

        studentId = student.getStudentId();
        name = student.getName();
        grade = student.getGrade();

        StudentResponseDto studentResponseDto = new StudentResponseDto( studentId, name, grade );

        return studentResponseDto;
    }
}
