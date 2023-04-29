/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import java.io.Serializable;

/**
 *
 * @author LAPTOP
 */
public class SignUpCreateError implements Serializable{
    private String usernameLengthError;
    private String passwordLengthError;
    private String fullnameLengthError;
    private String confirmNotMatched;
    private String usernameIsExisted;
    private String emailValidateError;
    
    public SignUpCreateError() {
    }

    public SignUpCreateError(String usernameLengthError, String passwordLengthError, String fullnameLengthError, String confirmNotMatched, String usernameIsExisted, String emailValidateError) {
        this.usernameLengthError = usernameLengthError;
        this.passwordLengthError = passwordLengthError;
        this.fullnameLengthError = fullnameLengthError;
        this.confirmNotMatched = confirmNotMatched;
        this.usernameIsExisted = usernameIsExisted;
        this.emailValidateError = emailValidateError;
    }

    public String getUsernameLengthError() {
        return usernameLengthError;
    }

    public void setUsernameLengthError(String usernameLengthError) {
        this.usernameLengthError = usernameLengthError;
    }

    public String getPasswordLengthError() {
        return passwordLengthError;
    }

    public void setPasswordLengthError(String passwordLengthError) {
        this.passwordLengthError = passwordLengthError;
    }

    public String getFullnameLengthError() {
        return fullnameLengthError;
    }

    public void setFullnameLengthError(String fullnameLengthError) {
        this.fullnameLengthError = fullnameLengthError;
    }

    public String getConfirmNotMatched() {
        return confirmNotMatched;
    }

    public void setConfirmNotMatched(String confirmNotMatched) {
        this.confirmNotMatched = confirmNotMatched;
    }

    public String getUsernameIsExisted() {
        return usernameIsExisted;
    }

    public void setUsernameIsExisted(String usernameIsExisted) {
        this.usernameIsExisted = usernameIsExisted;
    }
    
    public String getEmailValidateError() {
        return emailValidateError;
    }
    
    public void setEmailValidateError(String emailValidateError) {
        this.emailValidateError = emailValidateError;
    }
}
