package step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.Money;
import step5.exception.NotEnoughInitMoneyException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @Test
    @DisplayName("초기 금액이 1000원이 안되어 예외가 나는 테스트")
    void notEnoughMoney() {
        assertThatThrownBy(() -> new Money(800)
        ).isInstanceOf(NotEnoughInitMoneyException.class)
                .hasMessageContaining(NotEnoughInitMoneyException.MESSAGE);
    }
}