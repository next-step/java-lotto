package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    @DisplayName("현재 금액에서 돈을 사용하면 그만큼 차감되어야 한다.")
    void useMoneyTest() {

        // given
        Money money = new Money(1_000);
        Money expected = new Money(0);

        // when
        Money result = money.useMoney(1_000);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("현재 금액에서 가격을 받으면 구입 갯수를 반환할 수 있다.")
    void calculatePurchaseCountTest() {

        // given
        Money money = new Money(10_000);
        int price = 1000;

        // when
        int result = money.calculatePurchaseCount(price);

        // then
        assertThat(result).isEqualTo(10);
    }

}