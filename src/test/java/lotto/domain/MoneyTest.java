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
}