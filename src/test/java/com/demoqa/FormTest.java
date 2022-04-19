package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormTest {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true; // браузер не будет закрываться после тестов.
        Configuration.baseUrl = "https://demoqa.com"; // Задать базовый УРЛ.
        Configuration.browserSize = "1920x1080"; // задать желаемый размер экрана.

    }
    @Test
    void fillFormTest() {
        // Шаги

        open("/automation-practice-form");
        $("[id=firstName]").setValue("James");
        $("[id=lastName]").setValue("Bond");
        $("[id=userEmail]").setValue("James@Bond.com");
        $(".custom-radio:nth-child(1) > .custom-control-label").click();
        $("[id=userNumber]").setValue("88005553535");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__day--020").click();
        $(".subjects-auto-complete__value-container").click();
        $("#subjectsInput").val("m");
        $("#subjectsInput").sendKeys(Keys.DOWN);
        $("#subjectsInput").sendKeys(Keys.DOWN);
        $("#subjectsInput").sendKeys(Keys.ENTER);
        $(".custom-checkbox:nth-child(1) > .custom-control-label").click();// Hobbies
        $(".custom-checkbox:nth-child(2) > .custom-control-label").click();// Hobbies
        $("#uploadPicture").uploadFromClasspath("image/Me.png"); // Downloand picture
        $("#currentAddress").val("My street");
        $("#state").click();
        $("#react-select-3-option-1").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();

////////////////////////////////////////////////////////////////////////////////////

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));





    }
}
