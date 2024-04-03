package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import utils.Language;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final ElementsCollection headlinesLinks = $$("div.sw21-header-nav__item");

    public MainPage openPage(Language language) {
        open("https://siberianhealth.com/" + language.url);

        return this;
    }

    public MainPage checkingHeadlines(List<String> expectedHeadlines) {
        headlinesLinks.filter(visible).shouldHave(texts(expectedHeadlines));

        return this;
    }

}
