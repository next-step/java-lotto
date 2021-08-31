package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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

    @Test
    @DisplayName("로또 구매가 불가능한 금액을 받으면 Excpetion을 반환해야 한다.")
    void checkAvailableForPurchaseLottoTest() {

        // given
        int input = 0;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Money(input))
            .withMessageMatching("로또 게임을 진행하려면 로또 가격보다 많은 돈을 넣어야 한다.");
    }

}