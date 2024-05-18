package com.young.SpringWorld.controller;

import com.young.SpringWorld.domain.Member;
import com.young.SpringWorld.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// spring container 가 만들어지면서 @Controller가 있으면 해당 클래스를 객체로 만들어 springContainer에 담아둠.
//@Controller 가 붙었을때 spring container에 담겨지는 객체를 관리하는 것이 스프링 빈을 관리한다고 한다.
@Controller
public class MemberController {
    private final MemberService memberService;

    //    @Autowired 애노태이션이 붙으면 스프링컨테이너에 있는 memberService객체를 주입함, dependency injection
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("models",members);
        return "members/memberList";
    }
}
