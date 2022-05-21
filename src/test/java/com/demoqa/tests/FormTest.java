package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class FormTest {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    Faker faker = new Faker();

    // parameters
    String FirstName = faker.name().firstName(),
            LastName = faker.name().lastName(),
            InputEmail = faker.internet().emailAddress(),
            gender = faker.demographic().sex(),
            address = faker.address().fullAddress(),
            MobilePhone = faker.phoneNumber().subscriberNumber(10),
            day = "19",
            month = "January",
            year = "2000",
            dayOfBirthday = format("%s %s,%s", day, month, year),
            subject = "Computer Science",
            hobbies = "Sports",
            photo = "Me.png",
            state = "Haryana",
            city = "Karnal";

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true; // браузер не будет закрываться после тестов.
        Configuration.baseUrl = "https://demoqa.com"; // Задать базовый УРЛ.
        Configuration.browserSize = "1920x1080"; // задать желаемый размер экрана.
    }

    @Test
    void fillFormTest() {
        registrationFormPage
                .openPage()
                .setFirstName(FirstName)
                .setLastName(LastName)
                .setUserEmail(InputEmail)
                .setGenderUser(gender)
                .setUserNumber(MobilePhone)
                .setBirthDate(day, month, year)
                .setSubjects(subject)
                .setHobby(hobbies)
                .setPhoto(photo)
                .setCurrentAddress(address)
                .setState(state)
                .setCity(city)
                .submitForm();



        //Проверки.
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        // Делал ошибку в том,что обращался к классу через #.
        // class="table-responsive" .table-responsive это класс и обращение идёт через точку. Самые простые проверки.
        $(".table-responsive").shouldHave(text("James Bond"), text("James@Bond.com"), text("Male"),
                text("8800555353"), text("20 July,1994"), text("Computer Science"), text("Sports, Reading"),
                text("James Bond"), text("Me.png"), text("My street"), text("Uttar Pradesh Lucknow"));

    }
}
