package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultTable;

import java.util.Locale;

import static utils.RandomUtils.*;

public class RegistrationFormPageObjectTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    ResultTable resultTable = new ResultTable();
    Faker faker = new Faker(new Locale("en-GB"));
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = getRandomGender(),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            day = getRandomDay(),
            month = getRandomMonth(),
            year = getRandomYear(),
            subject = getRandomSubject(),
            picture = getRandomPicture(),
            address = faker.address().streetAddress(),
            state = getRandomState(),
            city = getRandomCity(state),
            hobby = getRandomHobby();


    @Test
    void fullSuccessfulTest() {
        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(day, month, year)
                .setSubject(subject)
                .setHobbies(hobby)
                .uploadPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit();
        resultTable
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", "Mobile " + userNumber)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", picture)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void minSuccessfulTest() {
        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .clickSubmit();
        resultTable
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", "Mobile " + userNumber);
    }

    @Test
    void negativeWithoutLastNameTest() {
        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .clickSubmit();
        resultTable
                .checkModalNotAppear();
    }

    @Test
    void negativeWithoutNumberTest() {
        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .clickSubmit();
        resultTable
                .checkModalNotAppear();
    }
}
