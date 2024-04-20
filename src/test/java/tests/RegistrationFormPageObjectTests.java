package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultTable;

import static utils.TestData.*;

public class RegistrationFormPageObjectTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    ResultTable resultTable = new ResultTable();
    String firstName = getRandomFirstName(),
            lastName = getRandomLastName(),
            email = getRandomEmail(),
            gender = getRandomGender(),
            userNumber = getRandomPhoneNumber(),
            day = getRandomDay(),
            month = getRandomMonth(),
            year = getRandomYear(),
            subject = getRandomSubject(),
            picture = getRandomPicture(),
            address = getRandomAddress(),
            state = getRandomState(),
            city = getRandomCity(state),
            hobby = getRandomHobby();


    @Test
    @Tag("full_test")
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
    @Tag("min_success_test")
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
    @Tag("negative_test")
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
    @Tag("negative_test")
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
