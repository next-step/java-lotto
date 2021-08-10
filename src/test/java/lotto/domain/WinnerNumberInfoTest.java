package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.WrongLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerNumberInfoTest {

    @Test
    @DisplayName("당첨번호와 보너스 번호가 중복되지 않을경우, 어떠한 예외도 던지지 않는다.")
    void correct_winner_numbers() {
        int[] winnerNumbers = {1, 2, 3, 4, 5, 6};
        int bonusNumber = 7;

        assertThatCode(() -> new WinnerNumberInfo(winnerNumbers, bonusNumber))
            .doesNotThrowAnyException();
    }


    @Test
    @DisplayName("당첨번호와 보너스 번호가 중복될경우, 예외를 던진다.")
    void wrong_winner_numbers() {
        int[] winnerNumbers = {1, 2, 3, 4, 5, 6};
        int bonusNumber = 6;

        assertThatThrownBy(() -> new WinnerNumberInfo(winnerNumbers, bonusNumber))
            .isInstanceOf(WrongLottoNumberException.class);
    }

}