package study.cicdpractice.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import study.cicdpractice.domain.Member;


@Getter @Setter
@NoArgsConstructor
public class JoinRequest {

    private String nickname;

    private String password;
    private String passwordCheck;

    public Member toEntity(){
        return Member.builder()
                .nickname(this.nickname)
                .password(this.password)
                .build();
    }

}
