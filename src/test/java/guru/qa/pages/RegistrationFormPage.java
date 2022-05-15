package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {
    // locators
    SelenideElement firstNameInput = $("#firstName");
    // В случае если дев-р изменит локатор его останется только заменить тут.
    // тут надо написать список локаторов.



    //actions
    public RegistrationFormPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationFormPage setFirstName (String value ){
        $("#firstName").val(value);
        return this;


    }

    public RegistrationFormPage setLastName (String value ){
        $("#lastName").val(value);
        return this;
    }

    public RegistrationFormPage setEmail(String value ){
        $("#userEmail").val(value);
        return this;

    }

    public RegistrationFormPage setGender (String value ){
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key))
                .parent().shouldHave(text(value));

        return this;

    }

}

