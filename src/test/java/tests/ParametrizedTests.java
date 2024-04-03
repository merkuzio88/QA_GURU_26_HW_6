package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
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
    @ParameterizedTest
    void correctHeadlinesShouldBeVisible(Language language, List<String> expectedHeadlines) {

        mainPage
                .openPage(language)
                .checkingHeadlines(expectedHeadlines);
    }
}
