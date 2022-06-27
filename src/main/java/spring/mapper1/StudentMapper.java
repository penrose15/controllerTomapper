package spring.mapper1;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student studentPostDtoToStudent (StudentPostDto studentPostDto);
    Student studentPatchDtoToStudent(StudentPatchDto studentPatchDto);
    StudentResponseDto studentToStudentResponseDto(Student student);
}
