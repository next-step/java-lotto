package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {

    @DisplayName("금액 객체 생성 테스트")
    @Test
    void createMoney() {
        Money money = new Money(1000);

        assertThat(money).isNotNull();
    }

    @DisplayName("금액 지불 테스트")
    @Test
    void payMoneyTest() {
        Money money = new Money(2000);
        money = money.payMoney(1);

        Money expected = new Money(1000);

        assertThat(money).isEqualTo(expected);
    }
}
