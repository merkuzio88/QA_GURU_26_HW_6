package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
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
                        Language.RU,
                        List.of("Продукты", "О компании", "Бизнес", "Купить выгодно")
                ),
                Arguments.of(
                        Language.IT,
                        List.of("Prodotti", "Profilo dell’Azienda", "Business", "Acquisto vantaggioso")
                ),
                Arguments.of(
                        Language.BG,
                        List.of("Продукти", "За Компанията", "Бизнес", "Купете изгодно")
                )
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Проверка на локали {0} заголовков {1}")
    @Tag("MINOR")
    void correctHeadlinesShouldBeVisible(Language language, List<String> expectedHeadlines) {

        mainPage
                .openPage(language)
                .checkingHeadlines(expectedHeadlines);
    }

    @EnumSource(Language.class)
    @ParameterizedTest(name = "Проверка лого на локали {0}")
    @Tag("MINOR")
    void selectedCurrencyShouldBeDisplayedOnCurrencyButton(Language language) {
        mainPage
                .openPage(language)
                .checkingLogo();
    }
}
