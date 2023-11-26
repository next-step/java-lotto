package lotto_step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MoneyTest {

    @DisplayName("구매 금액을 전달하면 객체를 생성한다.")
    @Test
    void moneyTest() {
        int money = 1000;
        Money newMoney = new Money(money);

        assertThat(newMoney.getMoney()).isEqualTo(money);
    }

    @DisplayName("1000원 이하의 금액을 전달하면 IllegalArgumentException을 던진다.")
    @Test
    void moneyExceptionTest() {
        assertThatThrownBy(() -> new Money(100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액을 전달하면 구매 개수를 가져올 수 있다.")
    @Test
    void countTest() {
        Money money = new Money(10000);

        assertThat(money.lottoCount()).isEqualTo(10);
    }
}