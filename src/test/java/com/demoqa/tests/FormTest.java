package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

public class FormTest {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    Faker faker = new Faker();

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    // parameters
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            InputEmail = faker.internet().emailAddress(),
            gender = faker.demographic().sex(),
            address = faker.address().fullAddress(),
            mobilePhone = faker.phoneNumber().subscriberNumber(10),
            day = "19",
            month = "January",
            year = "2000",
            dayOfBirthday = format("%s %s,%s", day, month, year),
            fullName = format("%s %s", firstName, lastName),
            subject = "Computer Science",
            hobbies = "Sports",
            photo = "Me.png",
            state = "Haryana",
            city = "Karnal",
            endForm = "Thanks for submitting the form";

    @Test
    void fillFormTest() {
        registrationFormPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(InputEmail)
                .setGenderUser(gender)
                .setUserNumber(mobilePhone)
                .setBirthDate(day, month, year)
                .setSubjects(subject)
                .setHobby(hobbies)
                .setPhoto(photo)
                .setCurrentAddress(address)
                .setState(state)
                .setCity(city)
                .submitForm()

                //asserts
                .checkTitle(endForm)
                .checkResult("Student Name", fullName)
                .checkResult("Student Email", InputEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", mobilePhone)
                .checkResult("Date of Birth", dayOfBirthday)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", photo)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);

    }
}
