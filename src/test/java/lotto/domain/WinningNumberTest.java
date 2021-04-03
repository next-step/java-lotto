package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumberTest {


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @DisplayName("당첨번호에 해당 숫자가 포함되어 있으면 true")
    void containsTest(int num) {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6", new LottoNumber(7));
        assertThat(winningNumber.contains(new LottoNumber(num))).isTrue();
    }

    @Test
    @DisplayName("해당 번호가 보너스번호와 일치하면 true")
    void matchBonusTest() {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6", new LottoNumber(7));
        assertThat(winningNumber.isMatchBonus(new LottoNumber(7))).isTrue();
    }
}
