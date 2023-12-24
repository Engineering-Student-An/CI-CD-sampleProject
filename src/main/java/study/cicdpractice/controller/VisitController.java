package study.cicdpractice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import study.cicdpractice.domain.Visit;
import study.cicdpractice.domain.VisitCreateRequest;
import study.cicdpractice.repository.VisitRepository;

@Controller
@RequiredArgsConstructor
public class VisitController {
    private final VisitRepository visitRepository;

    @GetMapping("")
    public String home(Model model,
                       @PageableDefault(size = Integer.MAX_VALUE, sort = "visitTime", direction = Sort.Direction.DESC) Pageable pageable){
        Page<Visit> visits = visitRepository.findAll(pageable);
        model.addAttribute("visits", visits);
        model.addAttribute("visitCnt", visits.getTotalElements());
        model.addAttribute("visitCreateRequest", new VisitCreateRequest());
        return "home";
    }

    @PostMapping("/visit")
    public String visit(@ModelAttribute VisitCreateRequest visitCreateRequest) {
        visitRepository.save(visitCreateRequest.toEntity());
        return "redirect:/";
    }
}
