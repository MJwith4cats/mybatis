package com.mjwoo.mybatis.member;

import lombok.Data;

@Data
public class MemberSignUpRequestDto {

    private String m_mail;
    private String m_pw;
    private String m_name;
    private String m_gender;
    private String m_phone;

    public MemberSignUpRequestDto() {
        
    }

    public String getM_gender() {
        return m_gender;
    }

    public void setM_gender(String m_gender) {
        this.m_gender = m_gender;
    }

    public String getM_phone() {
        return m_phone;
    }

    public void setM_phone(String m_phone) {
        this.m_phone = m_phone;
    }

    public String getM_mail() {
        return m_mail;
    }

    public void setM_mail(String m_mail) {
        this.m_mail = m_mail;
    }

    public String getM_pw() {
        return m_pw;
    }

    public void setM_pw(String m_pw) {
        this.m_pw = m_pw;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public MemberSignUpRequestDto(String m_mail, String m_pw, String m_name, String m_gender, String m_phone) {
        this.m_mail = m_mail;
        this.m_pw = m_pw;
        this.m_name = m_name;
        this.m_gender = m_gender;
        this.m_phone = m_phone;
    }
}
