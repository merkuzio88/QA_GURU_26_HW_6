package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import pages.components.CalendarComponent;

import java.util.Objects;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            pictureUpload = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit"),
            stateAndCityFragment = $("#stateCity-wrapper");

    CalendarComponent calendarComponent = new CalendarComponent();

    @Step("Open registration form page")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    @Step("Remove banners")
    public RegistrationPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    @Step("Set first name {value}")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Set second name {value}")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Set email {value}")
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    @Step("Set gender {value}")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Set user number {value}")
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    @Step("Set date of birth {day}, {month}, {year}")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    @Step("Set subject {value}")
    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value)
                .sendKeys(Keys.ENTER);

        return this;
    }

    @Step("Set hobby {value}")
    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Upload picture {fileName}")
    public RegistrationPage uploadPicture(String fileName) {
        if (Objects.equals(Configuration.browser, "chrome")) {
            pictureUpload.uploadFromClasspath(fileName);
        }
        return this;
    }

    @Step("Set address {value}")
    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    @Step("Set state {state}")
    public RegistrationPage setState(String state) {
        stateInput.click();
        stateAndCityFragment.$(byText(state)).click();

        return this;
    }

    @Step("Set city {city}")
    public RegistrationPage setCity(String city) {
        cityInput.click();
        stateAndCityFragment.$(byText(city)).click();

        return this;
    }

    @Step("Click submit")
    public RegistrationPage clickSubmit() {
        submitButton.click();

        return this;
    }
}
