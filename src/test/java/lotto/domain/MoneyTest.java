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

    @DisplayName("나누려는 돈이 주어질 때, 정수 나눗셈 결과가 반환되어야 한다.")
    @ParameterizedTest
    @CsvSource({
            "10000,1000,10",
            "10100,1000,10"
    })
    void divideBy(int moneyValue, int anotherMoneyValue, int expected) {
        Money money = new Money(moneyValue);
        Money anotherMoney = new Money(anotherMoneyValue);
        assertThat(money.divideBy(anotherMoney)).isEqualTo(expected);
    }

    @DisplayName("0원으로 나눌 때, 예외가 발생해야 한다.")
    @Test
    void divideBy_givenZeroMoney() {
        Money money = new Money(1000);
        Money zeroMoney = new Money(0);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> money.divideBy(zeroMoney));
    }

}
