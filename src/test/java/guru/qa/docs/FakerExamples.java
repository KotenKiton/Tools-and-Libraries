package guru.qa.docs;

import com.github.javafaker.Faker;

import java.util.Locale;

import static guru.qa.utils.RandomUtils.*;

public class FakerExamples {
    public static void main(String[] args) {
        Faker faker = new Faker();

        System.out.println(faker.aquaTeenHungerForce());
        System.out.println(faker.backToTheFuture());
        System.out.println(faker.lebowski().character());
        System.out.println(faker.lebowski().quote());
        System.out.println(faker.lebowski().actor());
        System.out.println(faker.business().creditCardNumber());
        System.out.println(faker.internet().ipV4Address());
        System.out.println(faker.address().fullAddress());

        Faker fakerDe = new Faker(new Locale("de"));
        System.out.println(faker.address().fullAddress());

        Faker fakerJa = new Faker(new Locale("ja"));
        System.out.println(faker.address().fullAddress());

        Faker fakerRu = new Faker(new Locale("ru"));
        System.out.println(faker.address().lastName());

    }
}
