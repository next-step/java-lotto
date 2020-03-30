package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ResultViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6"})
    void testLottoGames(final String inputText) {
        ResultView resultViewTest = new ResultView(inputText);
        assertThat(resultViewTest.winnerNumber()).hasSize(6);
    }

}
