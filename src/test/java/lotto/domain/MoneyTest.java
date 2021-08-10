package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {
    Money money;

    @ParameterizedTest
    @ValueSource(longs = {0, 10_000, 4_000_000_000L })
    void 금액클래스에_금액이_주어지면_객체를_생성한다(long amount) {
        money = Money.from(amount);
        assertThat(money).isNotNull().isInstanceOf(Money.class);
    }

    @Test
    void 주어진_금액이_음수이면_예외를_던진다() {
        assertThatThrownBy(() -> Money.from(-1000))
            .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @MethodSource
    void 금액과_곱할_숫자가_주어지면_곱한값에_해당하는_금액을_가진_객체를_반환한다(Money money, int number, Money expected) {
        assertThat(money.multiply(number)).isEqualTo(expected);
    }

    private static Stream<Arguments> 금액과_곱할_숫자가_주어지면_곱한값에_해당하는_금액을_가진_객체를_반환한다() {
        return Stream.of(
            Arguments.of(Money.from(0), 0, Money.from(0)),
            Arguments.of(Money.from(1_000), 1, Money.from(1_000)),
            Arguments.of(Money.from(1_000_000_000), 3, Money.from(3_000_000_000L)),
            Arguments.of(Money.from(1_000_000_000_000L), 5, Money.from(5_000_000_000_000L))
        );
    }
}
