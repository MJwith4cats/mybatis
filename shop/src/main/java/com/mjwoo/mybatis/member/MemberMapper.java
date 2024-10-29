package com.mjwoo.mybatis.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    public void createMember(MemberSignUpRequestDto requestDto);
}
