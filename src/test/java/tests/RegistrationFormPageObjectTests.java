package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationFormPageObjectTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fullSuccessfulTest() {
        registrationPage
                .openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setEmail("ivanov@google.com")
                .setGender("Male")
                .setUserNumber("12223334455")
                .setDateOfBirth("01", "January", "1990")
                .setSubject("Chemistry")
                .setHobbies("Sports")
                .uploadPicture("img/example.jpg")
                .setAddress("Some City, Some Street, 123")
                .setStateAndCity("NCR", "Delhi")
                .clickSubmit();
        registrationPage
                .checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Student Email", "ivanov@google.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "Mobile 1222333445")
                .checkResult("Date of Birth", "01 January,1990")
                .checkResult("Subjects", "Chemistry")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "example.jpg")
                .checkResult("Address", "Some City, Some Street, 123")
                .checkResult("State and City", "NCR Delhi");
    }

    @Test
    void minSuccessfulTest() {
        registrationPage
                .openPage()
                .setFirstName("Svetlana")
                .setLastName("Petrova")
                .setGender("Female")
                .setUserNumber("1222333445")
                .clickSubmit();
        registrationPage
                .checkResult("Student Name", "Svetlana Petrova")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "Mobile 1222333445");
    }

    @Test
    void negativeWithoutLastNameTest() {
        registrationPage
                .openPage()
                .setFirstName("Svetlana")
                .setGender("Female")
                .setUserNumber("1222333445")
                .clickSubmit()
                .checkModalNotAppear();
    }

    @Test
    void negativeWithoutNumberTest() {
        registrationPage
                .openPage()
                .setFirstName("Svetlana")
                .setLastName("Petrova")
                .setGender("Female")
                .clickSubmit()
                .checkModalNotAppear();
    }
}
