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
            memberService.createAccountConfirm(requestDto);
        }catch(IllegalArgumentException ex){
            model.addAttribute("errorMessage", ex.getMessage());

        }


        String nextPage = "home";

        return nextPage;
    }

    //이메일 중복 확인
    @PostMapping("/checkEmail")
    @ResponseBody
    public Map<String, Object> checkEmail(@RequestParam("m_mail") String mMail) {
        Map<String, Object> response = new HashMap<>();

        if (memberService.isEmailExists(mMail) != null) {
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
    @ResponseBody 
    public Map<String, Object> signInConfirm(@ModelAttribute MemberSignInRequestDto requestDto, HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        Member member = memberService.signInConfirm(requestDto);
        //Member 대신 Long member의 id를 가져와서 세션에 저장하도록 수정
        if (member == null) {
            response.put("error", true);
            response.put("message", "비밀번호를 다시 확인해주세요.");
        } else {
            session.setAttribute("signedInDto", member);
            session.setMaxInactiveInterval(60 * 30);
            response.put("error", false);
            response.put("redirectUrl", "/");
        }

        return response; // JSON 응답 반환
    }


    //로그아웃
    @GetMapping("/signOutConfirm")
    public String signOutConfirm(HttpSession session) {
        String nextPage = "redirect:/";

        session.invalidate();

        return nextPage;
    }

    //회원정보 수정
    @GetMapping("/editAccountForm")
    public String editAccountForm(HttpSession session, Model model){

        Member member = (Member) session.getAttribute("signedInDto");

        //Member member = memberService.showMember(mMail);

        System.out.println("member : "+member);

        model.addAttribute("member", member);

        String nextPage = "member/edit_account_form";

        return nextPage;
    }

    //회원정보 수정 확인
    @PostMapping("/editAccountConfirm")
    public String editAccountConfirm(@ModelAttribute MemberSignUpRequestDto requestDto, HttpSession session){
        log.info("회원정보 수정 확인");

        String nextPage = "redirect:/";

        int result = memberService.updateMember (requestDto);

        if (result > 0) {
            log.info("잘됐음");
            MemberSignUpRequestDto SignedInMember  = memberService.getSignedInMember(requestDto.getmMail());
            session.setAttribute("SignedInMember", SignedInMember);
            session.setMaxInactiveInterval(60 * 30);

            return nextPage;
        } else {
            log.info("실패했음");
            return nextPage;
        }
    }

    //회원 탈퇴
//    @PostMapping("deleteAccountConfirm")
//    public String
}
