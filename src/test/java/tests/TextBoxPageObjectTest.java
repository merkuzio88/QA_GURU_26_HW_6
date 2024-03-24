package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxPageObjectTest extends TestBase {

    TextBoxPage testBoxPage = new TextBoxPage();

    @Test
    void fullSuccessfulTest() {
        testBoxPage
                .openPage()
                .setFullName("Ivan Ivanov")
                .setEmail("ivanov@google.com")
                .setCurrentAddress("Tverskaya 5")
                .setPermanentAddress("Nevsky 2")
                .clickSubmit();
        testBoxPage
                .checkResult("Name:", "Ivan Ivanov")
                .checkResult("Email:", "ivanov@google.com")
                .checkResult("Current Address :", "Tverskaya 5")
                .checkResult("Permananet Address :", "Nevsky 2");
    }
}
