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

    private static String removeSeparators(String content) {
        String toRemove = "[\\(\\)\\s\\-]";
        String parsedContent = content.replaceAll(toRemove, "");
        return parsedContent;
    }

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getPhoneNumber() {
        String rawPhoneNumber = faker.phoneNumber().phoneNumber();
        String parsedPhoneNumber = removeSeparators(rawPhoneNumber);
        Boolean[] booleans = {false, true};
        if(getRandom(booleans)) {
            parsedPhoneNumber = parsedPhoneNumber.substring(0, 2) + "9" + parsedPhoneNumber.substring(2, 10);
        }
        return parsedPhoneNumber;
    }

    public static String getEmailAddress() {
        return faker.internet().emailAddress();
    }

    public static String getAddressLine1() {
        return faker.address().streetName();
    }

    public static String getAddressLine2() {
        return faker.address().secondaryAddress();
    }

    public static String getCity() {
        return faker.address().city();
    }

    public static String getCountryRegion() {
        return "BRA-" + faker.address().stateAbbr();
    }

    public static String getPostalCode() {
        String rawPostalCode = faker.address().zipCode();
        String parsedPostalCode = removeSeparators(rawPostalCode);
        return parsedPostalCode;
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
