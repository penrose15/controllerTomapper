package spring.mapper1;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StudentResponseDto {
    private long studentId;
    private String name;
    private Grade grade;
}
