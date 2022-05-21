package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponents;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {

    CalendarComponents calendar = new CalendarComponents();

    //Locators
    SelenideElement FirstName = $("#firstName");
    SelenideElement LastName = $("#lastName");
    SelenideElement InputEmail = $("#userEmail");
    SelenideElement Gender = $("#genterWrapper");
    SelenideElement MobilePhone = $("#userNumber");
    SelenideElement DateOfBirth = $("#dateOfBirthInput");
    SelenideElement InputSubject = $("#subjectsInput");
    SelenideElement inputHobby = $("#hobbiesWrapper");
    SelenideElement UploadPhoto = $("#uploadPicture");
    SelenideElement InputAddress = $("#currentAddress");
    SelenideElement State = $("#state");
    SelenideElement City = $("#city");


    //Actions
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        FirstName.setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        LastName.setValue(value);

        return this;
    }

    public RegistrationFormPage setUserEmail(String value) {
        InputEmail.setValue(value);

        return this;
    }

    public RegistrationFormPage setGenderUser(String value) {
        Gender.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        DateOfBirth.click();
        calendar.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage setUserNumber(String value) {
        MobilePhone.setValue(value);

        return this;
    }

    public RegistrationFormPage setSubjects(String subject) {
        InputSubject.setValue(subject).pressEnter(); // Если не дописать нажми Enter то текст Предмета не будет введён!

        return this;
    }

    public RegistrationFormPage setHobby(String hobby) {
        inputHobby.$(byText(hobby)).click();

        return this;
    }

    public RegistrationFormPage setPhoto(String Image) { // Parametr Image never used
        UploadPhoto.uploadFromClasspath("Image/Me.png");
        //путь нужно указать полностью! начиная с папки Image. иначе "Me.png" будет просто строка с ошибкой file NFound

        return this;
    }

    public RegistrationFormPage setCurrentAddress(String address) {
        InputAddress.setValue(address);

        return this;
    }

    public RegistrationFormPage setState (String value) {
        InputAddress.setValue(value);

        return this;
    }

    public RegistrationFormPage setCity (String value) {
        InputAddress.setValue(value);

        return this;
    }

    public RegistrationFormPage submitForm () {
        $("#submit").pressEnter();

        return this;
    }
}
