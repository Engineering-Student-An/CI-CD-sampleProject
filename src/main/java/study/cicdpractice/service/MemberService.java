package study.cicdpractice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.cicdpractice.domain.dto.JoinRequest;
import study.cicdpractice.repository.MemberRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void join(JoinRequest joinRequest){
        memberRepository.save(joinRequest.toEntity());
    }

}
