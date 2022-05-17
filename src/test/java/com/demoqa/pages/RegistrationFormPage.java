package com.demoqa.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {

    // locatros

    //actions
    public RegistrationFormPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value){
        $("#firstName").setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName(String value){
        $("#lastName").setValue(value);

        return this;
    }

    public RegistrationFormPage setUserEmail(String value){
        $("#userEmail").setValue(value);

        return this;
    }

    public RegistrationFormPage setGenderUser(String value){
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setUserNumber(String value){
        $("#userNumber").setValue(value);

        return this;
    }
}
