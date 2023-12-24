package study.cicdpractice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VisitCreateRequest {
    private String name;
    private String message;

    public Visit toEntity(){
        return Visit.builder()
                .name(this.name)
                .message(this.message)
                .visitTime(LocalDateTime.now())
                .build();
    }
}
