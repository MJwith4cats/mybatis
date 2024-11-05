package com.mjwoo.mybatis.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private Long mId;
    private String mPw;
    private String mName;
    private String mGender;
    private String mMail;
    private String mPhone;
    private LocalDateTime mRegDate;
    private LocalDateTime mModDate;
    private LocalDateTime mDelDate;
    private int mIsDeleted;

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
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

    public String getmMail() {
        return mMail;
    }

    public void setmMail(String mMail) {
        this.mMail = mMail;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public LocalDateTime getmRegDate() {
        return mRegDate;
    }

    public void setmRegDate(LocalDateTime mRegDate) {
        this.mRegDate = mRegDate;
    }

    public LocalDateTime getmModDate() {
        return mModDate;
    }

    public void setmModDate(LocalDateTime mModDate) {
        this.mModDate = mModDate;
    }

    public LocalDateTime getmDelDate() {
        return mDelDate;
    }

    public void setmDelDate(LocalDateTime mDelDate) {
        this.mDelDate = mDelDate;
    }

}
