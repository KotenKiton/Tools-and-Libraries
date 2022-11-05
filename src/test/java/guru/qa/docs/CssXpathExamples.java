package guru.qa.docs;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {
    void CssXpathExamples() {

        //1)Cначала ищем data-testid
         //2) Если нет testid искать id(#)
        //3)На type не смотреть. Смотреть на name
        // но если нет тестайди,name, то смотреть на класс.
        //4) class = "inputtext login_form_input_box"
        //data-testid - добавляют по просьбе автоматизатора
        $("[id=email]").setValue("123");// Одно и тоже но разная запись
        $("#email").setValue("123");// Одно и тоже но разная запись( с решёткой красивее)
        $("#email").setValue("123");// - Вот так делать
        $(byId("email")).setValue("123");// Одно и тоже
        $(By.id("email")).setValue("123");// Одно и тоже
        // смысл один и тот же но 4 разных способа записи.

        // Примеры Xpath
        $x("//*[@id='email']").setValue("123");
        $(byXpath("//*[@id='email']")).setValue("123");

        $(byName("email")).setValue("123");

    //data-testid=email data-testid атрибут - его значение email
    // input type ="email" // type это тип элемента с имейлом.чтобы подсвечивалась ошибка.НА type не смотреть!
        // class тоже не смотреть
        // name такой же уникалный как id
        // 3* работа с классом
        $(".inputtext.login_form_input_box").setValue("123");
        $("input.inputtext.login_form_input_box").setValue("123");
        // input это тип элемента

        //$(byText("Hello,qa.guru"));// поиск по тексту
        //$(withText("Hello qa.guru"));// Поиск по строке( какому то куску)

        // рекомендуют пользоваться СSS. CSS + Selenide закрывает все задачи.

    }
}
