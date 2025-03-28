package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @DisplayName("구매 가능 여부를 판단할 수 있다.")
    @Test
    void checkPayAbleTest() {
        Money money = new Money(999);
        int buyAblePrice = 998;
        int notAblePrice = 1000;

        assertAll(() -> assertThat(money.checkPayAble(buyAblePrice)).isTrue(),
                () -> assertThat(money.checkPayAble(notAblePrice)).isFalse());
    }

    @DisplayName("구매 할 수 있다.")
    @Test
    void payTest() {
        Money money = new Money(999);

        money = money.pay(99);

        assertThat(money).isEqualTo(new Money(900));
    }
}
