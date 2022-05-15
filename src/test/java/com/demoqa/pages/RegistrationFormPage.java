package com.demoqa.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {

    // locatros

    //actions
    public void openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }

    public void setFirstName(String value){
        $("#firstName").setValue(value);
    }

    public void setLastName(String value){
        $("#lastName").setValue(value);
    }

    public void setUserEmail(String value){
        $("#userEmail").setValue(value);
    }

    public void setGenderUser(String value){
        $("#genterWrapper").$(byText(value)).click();
    }

    public void setUserNumber(String value){
        $("#userNumber").setValue(value);
    }
}
