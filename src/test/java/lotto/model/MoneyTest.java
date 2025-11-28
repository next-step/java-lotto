package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MoneyTest {
    @Test
    @DisplayName("로또 구입 금액은 1000원 단위여야 한다.")
    public void validTest() {
        Money money = new Money(10000);
        assertThat(money).isEqualTo(new Money(10000));
    }

    @Test
    @DisplayName("로또 구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    public void invalidTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(1500));
    }
}