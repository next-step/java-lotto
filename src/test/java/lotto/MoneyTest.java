package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @Test
    @DisplayName("구입 금액은 0보다 커야 한다")
    void amountMustBePositive() {
        assertThatThrownBy(() -> Money.of(0))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입 금액은 1000원 단위여야 한다")
    void amountMustBeMultipleOf1000() {
        assertThatThrownBy(() -> Money.of(1500))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입 금액을 1000으로 나눈 값이 로또 구매 수량이다")
    void ticketCountCalculation() {
        Money money = Money.of(14000);
        assertThat(money.ticketCount()).isEqualTo(14);
    }
}
