package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "100000"})
    @DisplayName("정상 금액 생성")
    void createSuccess(String input) {
        new Money(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "99999999"})
    @DisplayName("비정상 금액 생성")
    void createFail(String input) {
        Assertions.assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid");
    }

    @Test
    @DisplayName("금액을 더할 수 있다")
    void add() {
        Money money = new Money("1000");
        Money other = new Money("2000");

        Assertions.assertThat(money.add(other).value()).isEqualTo(3000);
    }

    @Test
    @DisplayName("금액을 뺄 수 있다")
    void subtract() {
        Money money = new Money("3000");
        Money other = new Money("2000");

        Assertions.assertThat(money.subtract(other).value()).isEqualTo(1000);
    }

    @Test
    @DisplayName("금액은 0원 이상이다")
    void isPositive() {
        Money money = new Money("1000");
        Assertions.assertThat(money.value()).isNotNegative();
    }

    @Test
    @DisplayName("금액이 0원 미만이면 예외가 발생한다")
    void isNegative() {
        Assertions.assertThatThrownBy(() -> new Money("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}