package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputNumberTest {
    @Test
    void 당첨번호_생성() {
        InputNumber inputNumber = new InputNumber("1, 2, 3, 4, 5, 6", "7");
        assertThat(inputNumber.winningNumbers()).isEqualTo(List.of(new lotto.domain.Number(1), new lotto.domain.Number(2), new lotto.domain.Number(3), new lotto.domain.Number(4), new lotto.domain.Number(5), new Number(6)));
    }

    @Test
    void 총합() {
        InputNumber inputNumber = new InputNumber("1, 2, 3, 4, 5, 6", "7");
        assertThat(inputNumber.sumMatchCount(List.of(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6)))).isEqualTo(6);
    }

    @Test
    void 보너스_번호_일치_여부() {
        InputNumber inputNumber = new InputNumber("1, 2, 3, 4, 5, 6", "7");
        assertThat(inputNumber.isMatchBonusNo(List.of(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6)))).isFalse();
        assertThat(inputNumber.isMatchBonusNo(List.of(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(7)))).isTrue();
    }
}