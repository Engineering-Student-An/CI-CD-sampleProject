package study.cicdpractice.controller;

import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.Join;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import study.cicdpractice.domain.Member;
import study.cicdpractice.domain.dto.JoinRequest;
import study.cicdpractice.repository.MemberRepository;
import study.cicdpractice.service.MemberService;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @GetMapping("")
    public String home(Model model,
                       @PageableDefault(size = Integer.MAX_VALUE, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        Page<Member> members = memberRepository.findAll(pageable);
        model.addAttribute("members", members);
        model.addAttribute("membersCount", members.getTotalElements());
        model.addAttribute("joinRequest", new JoinRequest());
        return "home";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute JoinRequest joinRequest, Model model) {
        memberService.join(joinRequest);
        return "redirect:/";
    }
}
