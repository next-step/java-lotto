package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class ResultViewTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(1);
    }

    @DisplayName("당첨번호를 , 를 기준으로 숫자를 6개 입력받을 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6"})
    void testLottoGames(final String inputText) {
        ResultView resultView = new ResultView(inputText);
        assertThat(resultView.winnerNumber().getLottoNumbers()).hasSize(6);
    }

    @DisplayName("당첨번호를 중복없이 6개 숫자를 입력받는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1, 1, 2, 2, 3, 6"})
    void testValidateDuplicate(final String inputText) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new ResultView(inputText));
    }

    @DisplayName("당첨번호는 1부터 45사이에 있어야한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 46, 0, 2"})
    void testLottoInRange(final String inputText) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new ResultView(inputText));
    }
}
