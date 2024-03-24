package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class MoneyTest {

    @Test
    @DisplayName("같은 금액이 들어오면 동등한 객체다.")
    void setMoney() {
        Money firstMoney = new Money(14_000);
        Money secondMoney = new Money(14_000);

        assertThat(firstMoney).isEqualTo(secondMoney);
    }

    @Test
    @DisplayName("금액은 음수가 들어올 수 없다.")
    void minusMoneyTest() {
        assertThatThrownBy(() -> new Money(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0원 미만");
    }

    @Test
    @DisplayName("당첨금 / 로또 구매 비용으로 수익률을 계산한다")
    void winningRateTest() {
        Money money = new Money(5000);
        double calculateRate = money.calculateRate(2_000_000_000);

        assertThat(calculateRate).isEqualTo(400_000.0);
    }
}