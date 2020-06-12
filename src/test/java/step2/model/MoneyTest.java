package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @DisplayName("정적 생성자는 Money 인스턴스를 반환")
    @ValueSource(ints = {0, 1000, 2000, 3000})
    @ParameterizedTest
    void valueOf(int amount) {
        Money money = Money.valueOf(amount);

        assertThat(money).isInstanceOf(Money.class);
        assertThat(money.getValue()).isEqualTo(amount);
    }

    @DisplayName("두 값을 합친 Money 객체 반환")
    @MethodSource("provideMoneyForPlus")
    @ParameterizedTest(name = "''{0}''과 ''{1}''을 더하면 ''{2}''")
    void plus(Money money, Money plusMoney, Money expected) {
        Money newMoney = money.plus(plusMoney);

        assertThat(newMoney).isEqualTo(expected);
    }

    private static Stream<Arguments> provideMoneyForPlus() {
        return Stream.of(
                Arguments.of(Money.valueOf(0), Money.valueOf(0), Money.valueOf(0)),
                Arguments.of(Money.valueOf(1000), Money.valueOf(0), Money.valueOf(1000)),
                Arguments.of(Money.valueOf(5000), Money.valueOf(4000), Money.valueOf(9000))
        );
    }

    @DisplayName("입력한 금액을 뺀 Money 객체 반환")
    @MethodSource("provideMoneyForMinus")
    @ParameterizedTest(name = "''{0}''에서 ''{1}''을 빼면  ''{2}''")
    void minus(Money money, Money minusMoney, Money expected) {
        Money newMoney = money.minus(minusMoney);

        assertThat(newMoney).isEqualTo(expected);
    }

    private static Stream<Arguments> provideMoneyForMinus() {
        return Stream.of(
                Arguments.of(Money.valueOf(0), Money.valueOf(0), Money.valueOf(0)),
                Arguments.of(Money.valueOf(1000), Money.valueOf(0), Money.valueOf(1000)),
                Arguments.of(Money.valueOf(5000), Money.valueOf(4000), Money.valueOf(1000))
        );
    }

    @DisplayName("입력한 금액이 보유 금액을 초과하면 예외 발생")
    @Test
    void minusExceptionThrown() {
        assertThatThrownBy(() ->  Money.valueOf(0).minus(Money.valueOf(1)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
