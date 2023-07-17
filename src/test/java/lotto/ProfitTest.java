package lotto;

import lotto.domain.Money;
import lotto.domain.Profit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitTest {

    @Test
    @DisplayName("Money 객체 두개를 입력받아 수익률 객체를 생성한다.")
    void create() {
        Assertions.assertThatNoException()
                .isThrownBy(() -> new Profit(5000, 1000));
    }

    @Test
    @DisplayName("원금이 0일 경우 예외를 던진다.")
    void validateNotZeroDominator() {
        Assertions.assertThatThrownBy(() -> new Profit(5000, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
