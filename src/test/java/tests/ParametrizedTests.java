package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import pages.MainPage;
import utils.Language;

import java.util.List;
import java.util.stream.Stream;

public class ParametrizedTests {

    MainPage mainPage = new MainPage();

    static Stream<Arguments> correctHeadlinesShouldBeVisible() {
        return Stream.of(
                Arguments.of(
                        Language.EN,
                        List.of("Products", "About the Company", "Business", "Buy & save")
                ),
                Arguments.of(
                        Language.IT,
                        List.of("Prodotti", "Profilo dell’Azienda", "Business", "Acquisto vantaggioso")
                ),
                Arguments.of(
                        Language.ES,
                        List.of("Productos", "Sobre la Compañía", "Negocio", "Compra rentable")
                )
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Проверка на локали {0} заголовков {1}")
    @Tag("MINOR")
    void correctHeadlinesShouldBeVisible(Language language, List<String> expectedHeadlines) {

        mainPage
                .openPage(language.url)
                .checkingHeadlines(expectedHeadlines);
    }

    @EnumSource(Language.class)
    @ParameterizedTest(name = "Проверка лого на локали {0}")
    @Tag("BLOCKER")
    void selectedCurrencyShouldBeDisplayedOnCurrencyButton(Language language) {
        mainPage
                .openPage(language.url)
                .checkingLogo();
    }

    @CsvFileSource(resources = "/bannerTexts.csv")
    @ParameterizedTest(name = "Проверка текста {1} на локали {0}")
    @Tags({
            @Tag("BLOCKER"),
            @Tag("SMOKE")
    })
    @DisplayName("Проверка текста баннера на различных локалях")
    void checkingBa(String language, String expectedText){
        mainPage
                .openPage(language)
                .checkingBannerText(expectedText);
    }
}
