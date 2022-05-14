package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NumberOfLottosTest {

    @Test
    @DisplayName("생성자 확인")
    void create() {
        NumberOfLottos number = new NumberOfLottos(5);
        assertThat(number).isEqualTo(new NumberOfLottos(5));
    }

    @Test
    @DisplayName("로또 개수를 음수로 입력")
    void negativeException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new NumberOfLottos(-5)).withMessage("수동 로또 개수가 음수가 될 수 없습니다.");
    }

}