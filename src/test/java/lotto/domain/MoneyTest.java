package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MoneyTest {

    @Test
    @DisplayName("금액은 1000원 이상이어야 한다")
    void lotto_buy() {
        assertThatThrownBy(() -> new Money(999)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1000단위로 로또를 구매할 수 있다")
    void lotto_buyCount() {
        assertThat(new Money(3500).buyCount()).isEqualTo(3);
    }
}