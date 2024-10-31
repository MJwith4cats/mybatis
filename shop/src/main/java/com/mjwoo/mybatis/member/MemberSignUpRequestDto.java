package com.mjwoo.mybatis.member;

import lombok.Data;

@Data
public class MemberSignUpRequestDto {

    private String mMail;
    private String mPw;
    private String mName;
    private String mGender;

    public MemberSignUpRequestDto(String mMail, String mPw, String mName, String mGender, String mPhone) {
        this.mMail = mMail;
        this.mPw = mPw;
        this.mName = mName;
        this.mGender = mGender;
        this.mPhone = mPhone;
    }

    public MemberSignUpRequestDto() {

    }

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

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmGender() {
        return mGender;
    }

    public void setmGender(String mGender) {
        this.mGender = mGender;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    private String mPhone;

}
