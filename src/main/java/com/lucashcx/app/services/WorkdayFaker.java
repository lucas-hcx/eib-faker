package com.lucashcx.app.services;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

import java.text.SimpleDateFormat;

import com.github.javafaker.Faker;

public class WorkdayFaker {
    private static Faker faker = new Faker(new Locale("pt-BR"));
    private static Map<String, Set<Object>> uniqueValues = new HashMap<>();
    private static String staticRandom = String.format("%04d", faker.number().randomNumber(4, false));

    private static <T> T getRandom(T[] array) {
        int random = new Random().nextInt(array.length);
        return array[random];
    }

    private static String removeSeparators(String content) {
        String toRemove = "[\\(\\)\\s\\-]";
        String parsedContent = content.replaceAll(toRemove, "");
        return parsedContent;
    }

    public static Long completeCPF(Long number) {
        for (int i = 1; i <= 2; i++) {
            Long copyOfNumber = number.longValue();
            int digitMultiplier = 2;
            int sum = 0;
            while (copyOfNumber > 0) {
                int digitValue = (int) (copyOfNumber % 10);
                sum += digitValue * digitMultiplier;
                copyOfNumber = (copyOfNumber - digitValue) / 10;
                digitMultiplier++;
            }
            int mod11To11 = 11 - (sum % 11);
            int dv = mod11To11 >= 10 ? 0 : mod11To11;
            number = (number * 10) + dv;
        }
        return number;
    }

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return "TEST " + faker.name().lastName();
    }

    public static String getPhoneNumber() {
        String rawPhoneNumber = faker.phoneNumber().phoneNumber();
        String parsedPhoneNumber = removeSeparators(rawPhoneNumber);
        Boolean[] booleans = { false, true };
        if (getRandom(booleans)) {
            parsedPhoneNumber = parsedPhoneNumber.substring(0, 2) + "9" + parsedPhoneNumber.substring(2, 10);
        }
        return parsedPhoneNumber;
    }

    public static String getEmailAddress() {
        return faker.name().username() + "@example.com";
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
        String[] genders = { "Male", "Female" };
        return getRandom(genders);
    }

    public static String getDateOfBirth() {
        Date birthdayDate = faker.date().birthday();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(birthdayDate);
    }

    public static String getID() {
        Long randomNumber;
        do {
            randomNumber = faker.number().randomNumber(9, false);
        } while (randomNumber % 111_111_111L == 0L);
        Long cpfNumber = completeCPF(randomNumber);
        return String.format("%011d", cpfNumber);
    }

    public static String getOrganizationID() {
        return "TestOrg" + staticRandom + "a" + String.format("%04d", faker.number().randomNumber(4, false));
    }

    public static String getOrganizationName() {
        return "Test Organization " + staticRandom + " A " + String.format("%04d", faker.number().randomNumber(4, false));
    }

    public static String getJobName() {
        return faker.job().title();
    }

    public static Object getUnique(String methodString) {
        Object uniqueValue = null;
        try {
            Method methodObject = WorkdayFaker.class.getMethod(methodString);
            if(!uniqueValues.containsKey(methodString)) {
                uniqueValues.put(methodString, new HashSet<>());
            }
            do {
                uniqueValue = methodObject.invoke(WorkdayFaker.class);
            } while (uniqueValues.get(methodString).contains(uniqueValue));
            uniqueValues.get(methodString).add(uniqueValue);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return uniqueValue;
    }
    
}
