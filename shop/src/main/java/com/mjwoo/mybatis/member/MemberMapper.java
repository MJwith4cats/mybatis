package com.mjwoo.mybatis.member;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    public MemberSignInRequestDto findByMailAndPw(MemberSignInRequestDto requestDto);

    public void createMember(MemberSignUpRequestDto requestDto);

    public String findByMail(String m_mail);

    public List<MemberSignUpRequestDto> findAll();
}
