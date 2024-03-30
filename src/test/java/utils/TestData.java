package utils;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class TestData  {

    private final static Faker faker = new Faker(new Locale("en-GB"));

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }

    public static String getRandomFirstName() {

        return faker.name().firstName();
    }

    public static String getRandomLastName() {

        return faker.name().lastName();
    }

    public static String getRandomEmail() {

        return faker.internet().emailAddress();
    }

    public static String getRandomPhoneNumber() {

        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemFromArray(genders);
    }

    public static String getRandomSubject() {
        String[] subjects = {"English", "Maths", "Physics", "Computer Science",
                "Chemistry", "Commerce", "Accounting", "Civics", "Biology"};

        return getRandomItemFromArray(subjects);
    }

    public static String getRandomPicture() {
        String[] states = {"example.jpg", "example2.jpg", "example3.jpg", "example4.jpg", "example5.jpg"};

        return getRandomItemFromArray(states);
    }

    public static String getRandomAddress() {

        return faker.address().fullAddress();
    }

    public static String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

        return getRandomItemFromArray(states);
    }

    public static String getRandomCity(String state) {
        String[] cities;
        switch (state) {
            case "NCR":
                cities = new String[]{"Delhi", "Gurgaon", "Noida"};
                break;
            case "Uttar Pradesh":
                cities = new String[]{"Agra", "Lucknow", "Merrut"};
                break;
            case "Haryana":
                cities = new String[]{"Karnal", "Panipat"};
                break;
            case "Rajasthan":
                cities = new String[]{"Jaipur", "Jaiselmer"};
                break;
            default:
                return null;
        }

        return getRandomItemFromArray(cities);
    }

    public static String getRandomDay() {

        return String.valueOf(faker.number().numberBetween(1, 28));
    }

    public static String getRandomMonth() {

        return faker.options().option("January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December");
    }

    public static String getRandomYear() {

        return String.valueOf(faker.number().numberBetween(1950, 2023));
    }

    public static String getRandomHobby() {

        return faker.options().option("Sports", "Reading", "Music");
    }
}
