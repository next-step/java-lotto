package lotto.model;

import lotto.exception.LackMoneyException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MoneyTest {

    @Test
    void init() throws Exception {
        Assertions.assertThat(Money.from(100)).isInstanceOf(Money.class);
    }

    @Test
    @DisplayName("로또 갯수를 입력받아 로또가 총 얼마의 금액인지를 반환한다.")
    void convert() throws Exception {
        Assertions.assertThat(Money.convert(10)).isEqualTo(Money.from(10_000));
    }

    @Test
    @DisplayName("초기화 시 금액이 0 미만일 경우 예외를 던진다.")
    void initMoneyException() throws Exception {
        Assertions.assertThatThrownBy(() -> Money.from(-1))
                  .isInstanceOf(LackMoneyException.class)
                  .hasMessage("money cannot be less than " + Money.ZERO_VALUE);
    }

    @Test
    @DisplayName("구매 가능한 로또 갯수를 반환한다.")
    void getNumberOfPurchases() throws Exception {
        Money money = Money.from(10_000);
        Assertions.assertThat(money.getNumberOfPurchases()).isEqualTo(10);
    }

    @MethodSource
    @ParameterizedTest
    @DisplayName("두 금액을 더해 새 금액을 반환한다.")
    void addition(Money money, Money anotherMoney, Money expectedMoney) throws Exception {
        Assertions.assertThat(money.addition(anotherMoney)).isEqualTo(expectedMoney);
    }

    private static Stream<Arguments> addition() {
        return Stream.of(
                Arguments.of(Money.from(5_000), Money.from(500), Money.from(5_500)),
                Arguments.of(Money.from(5_000), Money.from(0), Money.from(5_000)),
                Arguments.of(Money.from(5_000), Money.from(5_000), Money.from(10_000))
        );
    }

    @MethodSource
    @ParameterizedTest
    @DisplayName("두 금액을 차이만큼의 새 금액을 반환한다.")
    void subtraction(Money money, Money anotherMoney, Money expectedMoney) throws Exception {
        Assertions.assertThat(money.subtraction(anotherMoney)).isEqualTo(expectedMoney);
    }

    private static Stream<Arguments> subtraction() {
        return Stream.of(
                Arguments.of(Money.from(5_000), Money.from(5_000), Money.from(0)),
                Arguments.of(Money.from(5_000), Money.from(4_999), Money.from(1)),
                Arguments.of(Money.from(5_000), Money.from(1), Money.from(4_999))
        );
    }

    @MethodSource
    @ParameterizedTest
    @DisplayName("금액과 곱할 수를 입력받아 곱한 새로운 금액을 반환한다.")
    void multiply(Money money, int operand, Money expectedCount) throws Exception {
        Assertions.assertThat(money.multiply(operand)).isEqualTo(expectedCount);
    }

    private static Stream<Arguments> multiply() {
        return Stream.of(
                Arguments.of(Money.from(5_000), 10, Money.from(50_000)),
                Arguments.of(Money.from(5_000), 50, Money.from(250_000)),
                Arguments.of(Money.from(5_000), 1, Money.from(5_000))
        );
    }

    @MethodSource
    @ParameterizedTest
    @DisplayName("최종 금액을 입력받아 수익률을 반환한다.")
    void earningRate(Money payment, Money earnings, double expectedRate) throws Exception {
        Assertions.assertThat(earnings.earningRate(payment)).isEqualTo(expectedRate);
    }

    private static Stream<Arguments> earningRate() {
        return Stream.of(
                Arguments.of(Money.from(5_000), Money.from(5_000), 1.0),
                Arguments.of(Money.from(5_000), Money.from(250_000), 50.0),
                Arguments.of(Money.from(5_000), Money.from(500), 0.1)
        );
    }

    @Test
    @DisplayName("로또 개수를 입력받아 로또 개수 * 로또 금액이 현재 금액보다 크면 참을 반환한다.")
    void isLackMoneyTrue() throws Exception {
        Money money = Money.from(10_000);
        Assertions.assertThat(money.isLackMoney(11)).isTrue();
    }

    @Test
    @DisplayName("로또 개수를 입력받아 로또 개수 * 로또 금액이 현재 금액보다 작으면 거짓을 반환한다.")
    void isLackMoneyFalse() throws Exception {
        Money money = Money.from(10_000);
        Assertions.assertThat(money.isLackMoney(9)).isFalse();
    }

    @Test
    @DisplayName("Money 객체를 int 객체로 변환한다.")
    void toInt() throws Exception {
        Money money = Money.from(10_000);
        Assertions.assertThat(money.toInt()).isEqualTo(10_000);
    }
}
