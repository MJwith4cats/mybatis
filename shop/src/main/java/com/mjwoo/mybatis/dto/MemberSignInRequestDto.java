package com.mjwoo.mybatis.dto;

import lombok.Data;

@Data
public class MemberSignInRequestDto {


    private String mMail;
    private String mPw;


    public String getmMail() {
        return mMail;
    }

    public void setmMail(String mMail) {
        this.mMail = mMail;
    }

    public String getmPw() {
        return mPw;
    }

    public void setmPw(String mPw) {
        this.mPw = mPw;
    }
}
