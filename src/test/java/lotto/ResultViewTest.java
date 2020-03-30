package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class ResultViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6"})
    void testLottoGames(final String inputText) {
        ResultView resultViewTest = new ResultView(inputText);
        assertThat(resultViewTest.winnerNumber()).hasSize(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 1, 2, 2, 3, 6"})
    void testValidateDuplicate(final String inputText) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new ResultView(inputText));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 46, 0, 2"})
    void testLottoInRange(final String inputText) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new ResultView(inputText));
    }


}
