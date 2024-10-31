package com.mjwoo.mybatis.member;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    public void createMember(MemberSignUpRequestDto requestDto);

    public String findByMail(String mMail);

    public List<MemberSignUpRequestDto> findAll();

    public Member selectMember(MemberSignInRequestDto requestDto);
}
