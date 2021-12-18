package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.dto.WinningRate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @ParameterizedTest
    @CsvSource(value = {"100, 100", "300, 300", "500, 500", "70000, 70000"})
    @DisplayName("새로운 객체를 생성해도 정상적으로 금액을 비교한다")
    public void equals(int amount, int otherAmount) {
        assertThat(new Money(amount)).isEqualTo(new Money(otherAmount));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -100, -500, -1000, -1500})
    @DisplayName("0원 미만의 금액을 인자로 받으면 예외를 던진다")
    public void InvalidMoneyException(int input) {
        assertThatThrownBy(() -> {
            new Money(input);
        }).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000, 500, 1500", "13000, 2000, 15000", "500, 600, 1100", "41000, 8500, 49500"})
    @DisplayName("금액을 인자로 받으면 현재 금액에서 합친 금액의 새로운 객체가 반환된다")
    public void addMoney(int amount, int otherAmount, int expected) {
        Money myMoney = new Money(amount);
        Money otherMoney = new Money(otherAmount);

        assertThat(myMoney.addMoney(otherMoney)).isEqualTo(new Money(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"1000, 500, 2", "15000, 5000, 3", "5000, 0, 0", "40000, 1000, 40"})
    @DisplayName("금액을 인자로 받으면 현재 금액에서 인자로 받은 금액을 나눈 비율 객체가 반환된다")
    public void calculatePercent(int amount, int otherAmount, int expected) {
        Money myMoney = new Money(amount);
        Money otherMoney = new Money(otherAmount);

        assertThat(myMoney.calculatePercent(otherMoney)).isEqualTo(new WinningRate(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"1000, 500, 2", "15000, 5000, 3", "4500, 1000, 4", "40000, 1000, 40"})
    @DisplayName("기본 금액을 인자로 받으면 현재금액에서 기본 금액을 나눈 몫이 반환된다")
    public void dividedAmount(int amount, int otherAmount, int expected) {
        assertThat(new Money(amount).dividedAmount(otherAmount)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000, 5000, true", "4000, 2000, false", "52000, 1000, false", "4000, 10000, true"})
    @DisplayName("가격을 인자로 받으면 현재 금액이 가격보다 작으면 참을 반환한다.")
    public void lessThanPrice(int amount, int otherAmount, boolean expected) {
        assertThat(new Money(amount).lessThanPrice(otherAmount)).isEqualTo(expected);
    }
}
