package com.mjwoo.mybatis.member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    @Autowired
    MemberService memberService;

    //회원가입
    @GetMapping("/signUpForm")
    public String signUpForm(Model model){
        System.out.println("회원가입 화면 불러오기");

        model.addAttribute("member", new MemberSignUpRequestDto());

        String nextPage = "member/sign_up";

        return nextPage;
    }

    //회원가입 완료
    @PostMapping("/signUpConfirm")
    public String signUpConfirm(@ModelAttribute MemberSignUpRequestDto requestDto){
        System.out.println("회원가입 완료");

        memberService.createAccountConfirm(requestDto);

        String nextPage = "home";

        return nextPage;
    }
}
