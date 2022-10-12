package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class MoneyTest {

    @DisplayName("0 보다 작은 숫자의 값으로 객체를 생성하면, 예외가 발생해야 한다.")
    @Test
    void create_givenNumberLessThanZero() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Money(-1));
    }

    @DisplayName("0원으로 나눌 때, 예외가 발생해야 한다.")
    @Test
    void divideBy_givenZeroMoney() {
        Money money = new Money(1000);
        Money zeroMoney = new Money(0);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> money.divideBy(zeroMoney));
    }

    @DisplayName("돈과 돈을 더하면, 덧셈 결과가 반환되어야 한다.")
    @Test
    void plus() {
        Money actual = new Money(10000).plus(new Money(1000));
        assertThat(actual).isEqualTo(new Money(11000));
    }

    @DisplayName("돈과 정수를 곱하면, 곱셈 결과가 반환되어야 한다.")
    @Test
    void multiply() {
        Money actual = new Money(1000).multiply(2);
        assertThat(actual).isEqualTo(new Money(2000));
    }

    @DisplayName("비교하려는 돈보다 작다면 true를 반환해야 하고, 그렇지 않다면 false를 반환해야 한다.")
    @ParameterizedTest
    @CsvSource({
            "1000,999,false",
            "1000,1000,false",
            "1000,1001,true",
    })
    void isLessThan(int moneyValue1, int moneyValue2, boolean expected) {
        assertThat(new Money(moneyValue1).isLessThan(new Money(moneyValue2))).isEqualTo(expected);
    }

}
