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
    SelenideElement FirstName = $("#firstName"),
     LastName = $("#lastName"),
     InputEmail = $("#userEmail"),
     Gender = $("#genterWrapper"),
     MobilePhone = $("#userNumber"),
     DateOfBirth = $("#dateOfBirthInput"),
     InputSubject = $("#subjectsInput"),
     inputHobby = $("#hobbiesWrapper"),
     UploadPhoto = $("#uploadPicture"),
     InputAddress = $("#currentAddress"),
     State = $("#state"),
     City = $("#city"),
     EndFScreen = $("#example-modal-sizes-title-lg");

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

    public RegistrationFormPage setPhoto(String Image) {
        UploadPhoto.uploadFromClasspath("Image/" + Image);
        // таким оразом название картинки не захардкоженно.( могу менять и название и
        return this;
    }

    public RegistrationFormPage setCurrentAddress(String address) {
        InputAddress.setValue(address);

        return this;
    }

    public RegistrationFormPage setState(String value) {
        State.click();
        $(byText(value)).scrollTo().click();

        return this;
    }

    public RegistrationFormPage setCity(String value) {
        City.click();
        $(byText(value)).scrollTo().click();

        return this;
    }

    public RegistrationFormPage submitForm() {
        $("#submit").pressEnter();

        return this;
    }

    public RegistrationFormPage checkTitle(String title) {
        EndFScreen.shouldHave(text(title));

        return this;
    }


    public RegistrationFormPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }
}
