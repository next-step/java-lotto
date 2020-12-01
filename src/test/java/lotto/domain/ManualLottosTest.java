package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created By mand2 on 2020-12-01.
 */
public class ManualLottosTest {

    @ParameterizedTest
    @DisplayName("수동으로 구매할 로또 수 입력")
    @ValueSource(strings = {"0", "1", "3"})
    void 수동으로_구매할_로또_수_입력(String inputManualRound) {
        // given
        String manualRound = inputManualRound;

        // when
        ManualLottos manualLottos = ManualLottos.from(manualRound);

        // then
        assertThat(manualLottos.round()).isEqualTo(Integer.valueOf(manualRound));
    }

    @ParameterizedTest
    @DisplayName("수동으로 구매할 로또 수가 빈칸일 때")
    @NullAndEmptySource
    void 수동으로_구매할_로또_수가_빈칸(String inputManulRound) {
        assertThatThrownBy(() -> ManualLottos.from(inputManulRound))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ManualLottos.MESSAGE_NON_NULL);
    }
    
    @ParameterizedTest
    @DisplayName("수동으로 구매할 로또 수가 정수형이 아닐 때")
    @ValueSource(strings = {"1r", "가", "11.1"})
    void 수동으로_구매할_로또_수가_숫자형이_아님(String inputManulRound) {
        assertThatThrownBy(() -> ManualLottos.from(inputManulRound))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ManualLottos.MESSAGE_NUMBER);
    }
    
    @ParameterizedTest
    @DisplayName("수동으로 구매할 로또 수가 음수일 때")
    @ValueSource(strings = {"-1", "-571", "-11"})
    void 수동으로_구매할_로또_수가_음수(String inputManulRound) {
        assertThatThrownBy(() -> ManualLottos.from(inputManulRound))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ManualLottos.MESSAGE_NUMBER_POSITIVE);
    }

}
