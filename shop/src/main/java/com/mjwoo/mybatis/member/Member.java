package com.mjwoo.mybatis.member;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    Long m_id;
    String m_pw;
    String m_name;
    String m_gender;
    String m_mail;
    String m_phone;
    String m_reg_date;
    String m_mod_date;
    String m_del_date;

    public Long getM_id() {
        return m_id;
    }

    public void setM_id(Long m_id) {
        this.m_id = m_id;
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

    public String getM_gender() {
        return m_gender;
    }

    public void setM_gender(String m_gender) {
        this.m_gender = m_gender;
    }

    public String getM_mail() {
        return m_mail;
    }

    public void setM_mail(String m_mail) {
        this.m_mail = m_mail;
    }

    public String getM_phone() {
        return m_phone;
    }

    public void setM_phone(String m_phone) {
        this.m_phone = m_phone;
    }

    public String getM_reg_date() {
        return m_reg_date;
    }

    public void setM_reg_date(String m_reg_date) {
        this.m_reg_date = m_reg_date;
    }

    public String getM_mod_date() {
        return m_mod_date;
    }

    public void setM_mod_date(String m_mod_date) {
        this.m_mod_date = m_mod_date;
    }

    public String getM_del_date() {
        return m_del_date;
    }

    public void setM_del_date(String m_del_date) {
        this.m_del_date = m_del_date;
    }
}
