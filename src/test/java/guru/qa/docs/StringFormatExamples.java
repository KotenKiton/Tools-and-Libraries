package guru.qa.docs;

import static java.lang.String.format;

public class StringFormatExamples {
    public static void main(String[] args) { // psvm
        String name = "username",
                subject = "you";
        // тут представленны два вида форматирования через String name = username и через
        // форматированный вывод строк c помощью (%s - cпецификатор формата. Их несколько)
        System.out.println("Hello, " + name + "! How are " + subject + "?");

        // Форматированный вывод строки через спецификатор формата.
        // лучше делать через спецификатор формата это лаконичнее и короче.
        System.out.println(format("Hello, %s! How are %s?", "username", "you"));


    }

}
