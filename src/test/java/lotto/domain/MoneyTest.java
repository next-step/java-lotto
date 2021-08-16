package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class MoneyTest {

    @ParameterizedTest(name = "나누어 떨어지는지 판별 할 수 있다.")
    @CsvSource(value = {"10000,1000,true", "10100,1000,false"})
    public void dividedTest(int amount, int divisor, boolean expected) {
        Money money = Money.of(amount);
        assertThat(money.isDivisibleBy(Money.of(divisor)))
                .isEqualTo(expected);
    }

    @DisplayName("Money amount 는 음수일 수 없다.")
    @Test
    public void invalidAmountTest() {
        int invalidAmount = -1000;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Money.of(invalidAmount))
                .withMessageContaining(String.valueOf(invalidAmount));
    }

    @Test
    public void moneyDivideTest() {
        assertThat(Money.of(10000).divide(Money.of(10)))
                .isEqualTo(1000);
    }

    @DisplayName("돈을 0으로 나눌 수 없다.")
    @Test
    public void divideMoneyByZeroTest() {
        Money money = Money.of(1000);
        Money zero = Money.zero();
        assertThat(money.isDivisibleBy(zero)).isFalse();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> money.divide(zero));
    }

}