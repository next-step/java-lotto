package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @Test
    @DisplayName("0원 미만이면 예외를 반환한다.")
    void moneyLessThan0() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Money(-10));
    }

}
