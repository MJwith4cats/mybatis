package com.mjwoo.mybatis;

import com.mjwoo.mybatis.member.Member;
import com.mjwoo.mybatis.member.MemberSignInRequestDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"","/"})
    public String home(HttpSession session, Model model){
        Member signedInMember = (Member) session.getAttribute("signedInDto");

        System.out.println("signedInMember : " +signedInMember);

        if (signedInMember != null) {
            model.addAttribute("mName", signedInMember.getmName()); // mName을 모델에 추가
        }

        return "home";
    }
}
