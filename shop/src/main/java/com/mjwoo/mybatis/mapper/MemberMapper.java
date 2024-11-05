package com.mjwoo.mybatis.mapper;

import com.mjwoo.mybatis.domain.Member;
import com.mjwoo.mybatis.dto.MemberSignInRequestDto;
import com.mjwoo.mybatis.dto.MemberSignUpRequestDto;
import com.mjwoo.mybatis.dto.MemberWithdrawRequestDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    //자바에서 interface는 기본적으로 public이기 때문에 접근제어자를 안 붙여줘도 됨
    void createMember(MemberSignUpRequestDto requestDto);

    String findByMail(String mMail);

    List<MemberSignUpRequestDto> findAll();

    Member selectMember(MemberSignInRequestDto requestDto);

    Member findByEmail(String mMail);

    int updateMember(MemberSignUpRequestDto requestDto);

    MemberSignUpRequestDto getSigningInMember(String mMail);

    int withdrawMember(String mMail);
}
