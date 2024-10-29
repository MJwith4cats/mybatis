package com.mjwoo.mybatis.member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    @Autowired
    MemberMapper memberMapper;
    
    public void createAccountConfirm(MemberSignUpRequestDto signUpRequestDto) {
        memberMapper.createMember(signUpRequestDto);
    }
}
