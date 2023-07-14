package lotto;

import lotto.domain.Count;
import lotto.domain.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    @DisplayName("정상적인 입력시 머니 객체가 정상적으로 생성된다.")
    void create() {
        int money = 14000;

        Assertions.assertThatNoException()
                .isThrownBy(() -> new Money(money));
    }

    @Test
    @DisplayName("음수 금액 입력시 생성자가 예외를 던진다.")
    void validateNegative() {
        Assertions.assertThatThrownBy(() -> new Money(-14000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구매 불가 금액 입력시 로또 구매에서 예외를 던진다.")
    void validateNoLotto() {
        Money zeroMoney = new Money(0);
        Money price = new Money(1000);
        Assertions.assertThatThrownBy(() -> zeroMoney.count(price))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("금액에 맞는 로또 개수를 반환한다.")
    void countLotto() {
        Money money = new Money(1234);
        Assertions.assertThat(money.count(new Money(1000))).isEqualTo(new Count(1));
    }

    @Test
    @DisplayName("수익률을 계산하여 리턴한다.")
    void profitRate() {
        Money profit = new Money(5000);
        Money principal = new Money(14000);
        Assertions.assertThat(Money.calculateProfitRate(profit, principal).getProfitRate()).isEqualTo((double) 5 / 14);
    }

    @Test
    @DisplayName("물건 개수를 곱하여 총 가격을 알아낸다.")
    void multiply() {
        Money box = new Money(5000);
        Assertions.assertThat(box.multiply(5)).isEqualTo(new Money(25000));
    }
}
