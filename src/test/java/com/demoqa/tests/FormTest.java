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
    String  FirstName = faker.name().firstName(),
            LastName = faker.name().lastName(),
            InputEmail = faker.internet().emailAddress(),
            gender = faker.demographic().sex(),
            address = faker.address().fullAddress(),
            MobilePhone = faker.phoneNumber().subscriberNumber(10),
            day = "19",
            month = "January",
            year = "2000",
            dayOfBirthday = format("%s %s,%s", day, month, year),
            FullName = format("%s %s", FirstName, LastName),
            subject = "Computer Science",
            hobbies = "Sports",
            photo = "Me.png",
            state = "Haryana",
            city = "Karnal",
            EndForm = "Thanks for submitting the form";

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
                .submitForm()

                //Asserts
                .checkTitle(EndForm)
                .checkResult("Student Name", FullName)
                .checkResult("Student Email", InputEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", MobilePhone)
                .checkResult("Date of Birth", dayOfBirthday)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", photo)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);

    }
}
