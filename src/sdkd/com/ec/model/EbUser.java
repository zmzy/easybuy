package sdkd.com.ec.model;

import java.util.Date;

/**
 * 用户表
 * Created by SDUST-132 on 2016/7/5.
 */
public class EbUser {
    private String euUserId;
    private String euUserName;
    private String euPassword;
    private String euSex;
    private Date euBirthday;
    private String identityCode;
    private String euEmail;
    private String euMobile;
    private String euAddress;
    private String euStatus;

    public String getEuUserId() {
        return euUserId;
    }

    public void setEuUserId(String euUserId) {
        this.euUserId = euUserId;
    }

    public String getEuUserName() {
        return euUserName;
    }

    public void setEuUserName(String euUserName) {
        this.euUserName = euUserName;
    }

    public String getEuPassword() {
        return euPassword;
    }

    public void setEuPassword(String euPassword) {
        this.euPassword = euPassword;
    }

    public String getEuSex() {
        return euSex;
    }

    public void setEuSex(String euSex) {
        this.euSex = euSex;
    }

    public Date getEuBirthday() {
        return euBirthday;
    }

    public void setEuBirthday(Date euBirthday) {
        this.euBirthday = euBirthday;
    }

    public String getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(String identityCode) {
        this.identityCode = identityCode;
    }

    public String getEuEmail() {
        return euEmail;
    }

    public void setEuEmail(String euEmail) {
        this.euEmail = euEmail;
    }

    public String getEuMobile() {
        return euMobile;
    }

    public void setEuMobile(String euMobile) {
        this.euMobile = euMobile;
    }

    public String getEuAddress() {
        return euAddress;
    }

    public void setEuAddress(String euAddress) {
        this.euAddress = euAddress;
    }

    public String getEuStatus() {
        return euStatus;
    }

    public void setEuStatus(String euStatus) {
        this.euStatus = euStatus;
    }
}
