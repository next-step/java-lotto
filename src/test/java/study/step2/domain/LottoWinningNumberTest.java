package study.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoWinningNumberTest {
    @DisplayName("당첨번호를 입력하는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,46", "0,1,2,3,4,5", "1,2,3,4,5,6,7"})
    void 당첨번호를_입력하는_경우(String input) {
        assertThatThrownBy(() -> new LottoWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}