package pages.components;

import com.codeborne.selenide.SelenideElement;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTable {

    private final SelenideElement resultTable = $(".table-responsive");

    public ResultTable checkResult(String key, String value) {
        resultTable.$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

    public ResultTable checkModalNotAppear() {
        resultTable.shouldNotBe(appear);

        return this;
    }
}
