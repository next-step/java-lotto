package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputNumberTest {
    @Test
    void 총합() {
        InputNumber inputNumber = new InputNumber("1, 2, 3, 4, 5, 6", "7");
        assertThat(inputNumber.countWinningNumbers(List.of(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6)))).isEqualTo(6);
    }

    @Test
    void 보너스번호_일치() {
        InputNumber inputNumber = new InputNumber("1, 2, 3, 4, 5, 6", "7");
        assertThat(inputNumber.existBonusNumber(new Number(7))).isTrue();
        assertThat(inputNumber.existBonusNumber(new Number(8))).isFalse();
    }
}