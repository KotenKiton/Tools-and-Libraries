package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static guru.qa.utils.RandomUtils.getRandomEmail;
import static guru.qa.utils.RandomUtils.getRandomString;
import static java.lang.String.format;

public class RegistrationFormWithFakerTests {


    Faker faker = new Faker();


    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            currentAddress = faker.rickAndMorty().quote();

    String expectedFullName = format("%s %s", firstName, lastName);


    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        // Подготовка.
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");// Отключает футер.
        executeJavaScript("$('#fixedban').remove()");// Отключает рекламу.
        //Шаги.
        $("#firstName").val(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(".custom-radio:nth-child(1) > .custom-control-label").click();
        $("#userNumber").setValue("88005553535");
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
        $(".custom-checkbox:nth-child(1) > .custom-control-label").click();// Hobbies.
        $(".custom-checkbox:nth-child(2) > .custom-control-label").click();// Hobbies.
        $("#uploadPicture").uploadFromClasspath("Image/Me.png"); // Select picture.
        $("#currentAddress").val(currentAddress);
        $("#state").click();
        $("#react-select-3-option-1").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();
        //Проверки.
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        // Делал ошибку в том,что обращался к классу через #.
        // class="table-responsive" .table-responsive это класс и обращение идёт через точку. Самые простые проверки.
        $(".table-responsive").shouldHave(text(firstName + "" + lastName), text(email), text("Male"),
                text("8800555353"), text("20 July,1994"), text("Computer Science"), text("Sports, Reading"),
                text("James Bond"), text("Me.png"), text("My street"), text("Uttar Pradesh Lucknow"));
    }
}
