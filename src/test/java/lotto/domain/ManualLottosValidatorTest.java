package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ManualLottosValidatorTest {

    @DisplayName("수동 로또 구매 장수가 입력값의 수보다 크다.")
    @Test
    void error_create_manual_lottos() {

        assertThatThrownBy(() -> ManualLottosValidator.validate(4, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("수동 구매한 로또수와 수동 로또 입력값이 맞지 않습니다.");
    }

    @DisplayName("수동 로또 구매 장수가 입력값의 수보다 작다.")
    @Test
    void error_create_manual_lottos2() {

        assertThatThrownBy(() -> ManualLottosValidator.validate(2, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("지불한 금액보다 수동으로 구입하려는 로또가 더 많습니다.");
    }
}