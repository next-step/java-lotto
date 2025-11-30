package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MoneyTest {

    @Test
    @DisplayName("금액은 0원 이상이어야 한다")
    void moneyBiggerThan0() {
        assertThatThrownBy(() -> new Money(0)).isInstanceOf(IllegalArgumentException.class);
    }
}