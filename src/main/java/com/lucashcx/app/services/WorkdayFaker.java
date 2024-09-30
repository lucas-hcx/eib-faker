package com.lucashcx.app.services;

import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.text.SimpleDateFormat;

import com.github.javafaker.Faker;

public class WorkdayFaker {
    private static Faker faker = new Faker(new Locale("pt-BR"));

    private static <T> T getRandom(T[] array) {
    int random = new Random().nextInt(array.length);
    return array[random];
    }

    public static String getFirstName() {
        return faker.name().name();
    }

    public static String getLastName() {
        return faker.name().name();
    }

    public static String getPhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    public static String getEmailAddress() {
        return faker.internet().safeEmailAddress();
    }

    public static String getAddressLine1() {
        return faker.address().streetAddress();
    }

    public static String getAddressLine2() {
        return faker.address().buildingNumber();
    }

    public static String getCity() {
        return faker.address().city();
    }

    public static String getCountryRegion() {
        return faker.address().state();
    }

    public static String getPostalCode() {
        return faker.address().zipCode();
    }

    public static String getGender() {
        String[] genders = {"Male", "Female"};
        return getRandom(genders);
    }

    public static String getDateOfBirth() {
        Date birthdayDate = faker.date().birthday();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(birthdayDate);
    }

    public static String getID() {
        long randomNumber = faker.number().randomNumber(11, false);
        return String.format("%011d", randomNumber);
    }
}
