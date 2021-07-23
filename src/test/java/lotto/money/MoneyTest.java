package lotto.money;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("돈 클래스 테스트")
class MoneyTest {

    @DisplayName("돈은 숫자를 가지고 초기화 한다.")
    @ValueSource(ints = {0, 10, 100})
    @ParameterizedTest
    void initMoney(int monet) {
        assertThat(Money.from(monet)).isInstanceOf(Money.class);
    }

    @DisplayName("초기화 하는 돈이 0 미만일 경우 예외를 발생시킨다.")
    @ValueSource(ints = {-1, -5})
    @ParameterizedTest
    void initMoneyException(int money) {
        assertThatThrownBy(() -> Money.from(money)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액을 전달하면 구매 가능한 갯수를 반환한다.")
    @MethodSource
    @ParameterizedTest
    void getAffordableCount(Money price, int expectedCount) {
        Money money = Money.from(10_000);

        assertThat(money.getAffordableCount(price)).isEqualTo(expectedCount);
    }

    private static Stream<Arguments> getAffordableCount() {
        return Stream.of(
                Arguments.of(Money.from(10_000), 1),
                Arguments.of(Money.from(1_000), 10),
                Arguments.of(Money.from(100), 100)
        );
    }

    @DisplayName("두 금액을 더하면 더한만큼의 새 금액을 반환한다.")
    @MethodSource
    @ParameterizedTest
    void addition(Money money, Money anotherMoney, Money expectedMoney) {
        assertThat(money.addition(anotherMoney)).isEqualTo(expectedMoney);
    }

    private static Stream<Arguments> addition() {
        return Stream.of(
                Arguments.of(Money.from(5_000), Money.from(500), Money.from(5_500)),
                Arguments.of(Money.from(5_000), Money.from(0), Money.from(5_000)),
                Arguments.of(Money.from(5_000), Money.from(5_000), Money.from(10_000))
        );
    }

    @DisplayName("금액과 가격을 전달하면 구매할 수 있는 개수를 반환한다.")
    @MethodSource
    @ParameterizedTest
    void affordableCount(Money money, Money price, int expectedCount) {
        assertThat(money.getAffordableCount(price)).isEqualTo(expectedCount);
    }

    private static Stream<Arguments> affordableCount() {
        return Stream.of(
                Arguments.of(Money.from(5_000), Money.from(500), 10),
                Arguments.of(Money.from(5_000), Money.from(100), 50),
                Arguments.of(Money.from(5_000), Money.from(5_000), 1)
        );
    }

    @DisplayName("금액과 곱할 수를 전달하면 곱한 금액을 반환한다.")
    @MethodSource
    @ParameterizedTest
    void multiply(Money money, int operand, Money expectedCount) {
        assertThat(money.multiply(operand)).isEqualTo(expectedCount);
    }

    private static Stream<Arguments> multiply() {
        return Stream.of(
                Arguments.of(Money.from(5_000), 10, Money.from(50_000)),
                Arguments.of(Money.from(5_000), 50, Money.from(250_000)),
                Arguments.of(Money.from(5_000), 1, Money.from(5_000))
        );
    }

    @DisplayName("원금과 최종 금액을 전달하면 수익률을 반환한다.")
    @MethodSource
    @ParameterizedTest
    void earningRate(Money payment, Money earnings, double expectedRate) {
        assertThat(earnings.earningRate(payment)).isEqualTo(expectedRate);
    }

    private static Stream<Arguments> earningRate() {
        return Stream.of(
                Arguments.of(Money.from(5_000), Money.from(5_000), 1.0),
                Arguments.of(Money.from(5_000), Money.from(250_000), 50.0),
                Arguments.of(Money.from(5_000), Money.from(500), 0.1)
        );
    }
}
