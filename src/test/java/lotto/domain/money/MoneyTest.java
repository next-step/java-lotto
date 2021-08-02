package lotto.domain.money;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MoneyTest {

    @DisplayName("0원 이상이면 Money를 만들 수 있다")
    @Test
    public void should_make_object_over_1_money() throws Exception {
        //arrange
        int moneyAmount = 1;

        //act
        Money money = Money.of(moneyAmount);

        //assert
        assertThat(money.getAmount()).isEqualTo(1);
    }

    @DisplayName("0원 이하이면 Money를 만들 수 없다")
    @ValueSource(ints = {-2, -1})
    @ParameterizedTest
    public void should_throw_exception_under_0_money(int money) throws Exception {
        //arrange, act, assert
        assertThatIllegalStateException().isThrownBy(() -> Money.of(money));
    }

    @DisplayName("두 Money 더하면 더한 Money를 반환한다.")
    @MethodSource
    @ParameterizedTest
    void can_addition(Money money, Money anotherMoney, Money expectedMoney) {
        assertThat(money.addition(anotherMoney)).isEqualTo(expectedMoney);
    }

    private static Stream<Arguments> can_addition() {
        return Stream.of(
                Arguments.of(Money.of(1_000), Money.of(1), Money.of(1_001)),
                Arguments.of(Money.of(1_000), Money.of(0), Money.of(1_000)),
                Arguments.of(Money.of(1_000), Money.of(1_000), Money.of(2_000))
        );
    }

    @DisplayName("Money와 곱할 수를 전달하면 곱한 금액의 Money를 반환한다.")
    @MethodSource
    @ParameterizedTest
    void can_multiply(Money money, int operand, Money expectedCount) {
        assertThat(money.multiply(operand)).isEqualTo(expectedCount);
    }

    private static Stream<Arguments> can_multiply() {
        return Stream.of(
                Arguments.of(Money.of(1_000), 2, Money.of(2_000)),
                Arguments.of(Money.of(1_000), 30, Money.of(30_000))
        );
    }

    @DisplayName("원금과 최종 금액을 전달하면 수익률을 반환한다.")
    @MethodSource
    @ParameterizedTest
    void can_calcurate_earningRate(Money money, Money earnings, double expectedRate) {
        assertThat(earnings.earningRate(money)).isEqualTo(expectedRate);
    }

    private static Stream<Arguments> can_calcurate_earningRate() {
        return Stream.of(
                Arguments.of(Money.of(1_000), Money.of(1_000), 1.0),
                Arguments.of(Money.of(1_000), Money.of(10_000), 10.0)
        );
    }

    @DisplayName("구매가능 기준액대비 입력받은 금액으로 살 수 있는 로또 장수를 계산한다")
    @Test
    public void should_calculate_affordable_count() throws Exception {
        //arrange
        Money money = Money.of(3_000);
        Money baseMoney = Money.of(1_000);
        int expectedCount = 3;

        //act
        int count = money.getAffordableCount(baseMoney);

        //assert
        assertThat(count).isEqualTo(expectedCount);
    }
}