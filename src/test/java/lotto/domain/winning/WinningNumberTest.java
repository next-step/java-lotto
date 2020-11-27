package lotto.domain.winning;

import lotto.domain.winning.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created By mand2 on 2020-11-19.
 */
class WinningNumberTest {

    @Test
    @DisplayName("당첨번호를 입력한다")
    void input_winning_number() {
        // given
        String inputNumber = "1, 2, 3, 4, 5, 6";

        // when
        WinningNumber winningNumber = WinningNumber.of(inputNumber, "7");

        // then
        assertThat(winningNumber.value().toString()).isEqualTo("[" + inputNumber+"]");
    }

    @ParameterizedTest
    @DisplayName("보너스볼이 당첨번호와 겹치면 예외처리")
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    void is_bonusBall_duplicated_from_winning_number(String inputBonusBall) {
        // given
        String inputNumber = "1, 2, 3, 4, 5, 6";

        // when & then
        assertThatThrownBy(() -> WinningNumber.of(inputNumber, inputBonusBall))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(WinningNumber.MESSAGE_BONUS_BALL_DUPLICATED);
    }


    @ParameterizedTest
    @DisplayName("보너스볼이 1~45 내의 값이 아니면 예외처리")
    @ValueSource(strings = {"61", "92", "0", "-4", "85", "776"})
    void is_bonusBall_between_1_to_45(String inputBonusBall) {
        // given
        String inputNumber = "1, 2, 3, 4, 5, 6";

        // when & then
        assertThatThrownBy(() -> WinningNumber.of(inputNumber, inputBonusBall))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
