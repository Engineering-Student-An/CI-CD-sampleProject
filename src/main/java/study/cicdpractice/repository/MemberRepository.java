package study.cicdpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.cicdpractice.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
