package com.mjwoo.mybatis.member;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@Log4j2
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

    //회원가입 확인
    @PostMapping("/signUpConfirm")
    public String signUpConfirm(@ModelAttribute MemberSignUpRequestDto requestDto, Model model){
        System.out.println("회원가입 완료");
        try{

        }catch(IllegalArgumentException ex){
            model.addAttribute("errorMessage", ex.getMessage());

        }
        memberService.createAccountConfirm(requestDto);

        String nextPage = "home";

        return nextPage;
    }

    //이메일 중복 확인
    @PostMapping("/checkEmail")
    @ResponseBody
    public Map<String, Object> checkEmail(@RequestParam("m_mail") String m_mail) {
        Map<String, Object> response = new HashMap<>();

        if (memberService.isEmailExists(m_mail) != null) {
            response.put("error", true);
            response.put("message", "이미 가입한 이메일이 존재합니다.");
        } else {
            response.put("error", false);
            response.put("message", "사용할 수 있는 이메일입니다.");
        }
        return response;
    }

    //모든 회원조회 페이지
    @GetMapping("/getAllMembers")
    public String getAllMembers(Model model){
        log.info("모든 회원 조회");

        List<MemberSignUpRequestDto> members = memberService.getAllMembers();
        log.info(members);

        model.addAttribute("members", members);
        System.out.println(members);
        String nextPage = "member/member_list";

        return nextPage;
    }


    //로그인 페이지
    @GetMapping("/signInForm")
    public String signInForm(Model model){
        System.out.println("로그인 폼 불러오기");

        model.addAttribute("member", new MemberSignInRequestDto());

        String nextPage = "member/sign_in";

        return nextPage;
    }
    
    //로그인 확인
    @PostMapping("/signInConfirm")
    public String signInConfirm(@ModelAttribute MemberSignInRequestDto requestDto, HttpSession session) {
        System.out.println("로그인 폼 확인");

        MemberSignInRequestDto signedInDto =
                (MemberSignInRequestDto) memberService.signInConfirm(requestDto);

        String nextPage = "home";

        if (signedInDto == null) {
            nextPage = "redirect:/member/sign_in";
        } else {
            session.setAttribute("signedInDto", signedInDto);
            session.setMaxInactiveInterval(60*30);
        }

        return nextPage;
    }

}
