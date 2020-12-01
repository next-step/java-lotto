package lotto.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created By mand2 on 2020-12-02.
 */
class RoundTest {

    @ParameterizedTest
    @DisplayName("수동으로 구매할 로또 수 입력")
    @ValueSource(strings = {"0", "1", "3"})
    void 수동으로_구매할_로또_수_입력(String inputManualRound) {
        Round round1 = Round.from(inputManualRound);
        Round round2 = Round.from(inputManualRound);

        assertThat(round1).isEqualTo(round2);
    }

    @ParameterizedTest
    @DisplayName("수동으로 구매할 로또 수가 빈칸일 때")
    @NullAndEmptySource
    void 수동으로_구매할_로또_수가_빈칸(String inputManulRound) {
        assertThatThrownBy(() -> Round.from(inputManulRound))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Round.MESSAGE_NON_NULL);
    }

    @ParameterizedTest
    @DisplayName("수동으로 구매할 로또 수가 정수형이 아닐 때")
    @ValueSource(strings = {"1r", "가", "11.1"})
    void 수동으로_구매할_로또_수가_숫자형이_아님(String inputManulRound) {
        assertThatThrownBy(() -> Round.from(inputManulRound))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Round.MESSAGE_NUMBER);
    }

    @ParameterizedTest
    @DisplayName("수동으로 구매할 로또 수가 음수일 때")
    @ValueSource(strings = {"-1", "-571", "-11"})
    void 수동으로_구매할_로또_수가_음수(String inputManulRound) {
        assertThatThrownBy(() -> Round.from(inputManulRound))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Round.MESSAGE_NUMBER_POSITIVE);
    }

}
