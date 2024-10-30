package com.mjwoo.mybatis.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class MemberService {

    @Autowired
    MemberMapper memberMapper;

    public String isEmailExists(String email) {

        return memberMapper.findByMail(email);
    }

    public void createAccountConfirm(MemberSignUpRequestDto signUpRequestDto) {

        memberMapper.createMember(signUpRequestDto);
    }

    public List<MemberSignUpRequestDto> getAllMembers() {

        log.info("호출됨");
        List<MemberSignUpRequestDto> members = memberMapper.findAll();
        log.info(members); // 리스트의 내용을 콘솔에 출력
        log.info("서비스 반환");
        return members;
    }


    public MemberSignInRequestDto signInConfirm(MemberSignInRequestDto requestDto) {

        MemberSignInRequestDto signedInDto =
                MemberMapper.findByMailAndPw(requestDto);

        if (signedInDto != null) {
            System.out.println("로그인 성공");
        } else {
            System.out.println("로그인 실패");
        }

        return signedInDto;

    }
}
