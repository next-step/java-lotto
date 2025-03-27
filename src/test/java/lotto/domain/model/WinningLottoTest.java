package lotto.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class WinningLottoTest {
    @ParameterizedTest(name = "당첨 번호를 6개 입력하지 않으면 예외를 던진다. 입력: {0}")
    @ValueSource(strings = {
            "1,2,3,4,5",
            "1,2,3,4,5,6,7"
    })
    void sizeOfWinningNumberTest(String input) {
        assertThatThrownBy(() -> WinningLotto.of(input, 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "당첨번호에 숫자가 아닌 것을 입력하면 예외를 던진다. 입력: {0}")
    @ValueSource(strings = {
            "1,2,3,4,5,ㅈ",
            "1,2,3,4,5,!"
    })
    void notNumberWinningNumberTest(String input) {
        assertThatThrownBy(() -> WinningLotto.of(input, 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "당첨번호에 중복되는 숫자를 입력하면 예외를 던진다. 입력: {0}")
    @ValueSource(strings = {
            "1,2,3,4,5,5"
    })
    void redundantWinningNumbersTest(String input) {
        assertThatThrownBy(() -> WinningLotto.of(input, 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호에 당첨번호와 중복되는 숫자를 입력하면 예외를 던진다. 입력: {0}")
    void redundantBonusNumbersTest() {
        String winningNumbers = "1,2,3,4,5,6";
        int bonusNumber = 6;
        assertThatThrownBy(() -> WinningLotto.of(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
