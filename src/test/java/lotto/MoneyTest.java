package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @Test
    @DisplayName("Money 는 0원을 기본으로 자신을 생성할 수 있다.")
    void constructorMethod() {
        // given
        Money money = new Money(0);

        // when

        // then
        assertThat(money).isEqualTo(new Money());
    }

    @ParameterizedTest
    @MethodSource("quotientMethodSource")
    @DisplayName("Money 는 다른 Money 로 나는 몫을 반환할 수 있다.")
    void quotientMethod(int numerator, int denominator, int result) {
        // given
        Money me = new Money(numerator);

        // when
        Money other = new Money(denominator);

        // then
        assertThat(me.quotient(other)).isEqualTo(result);
    }

    static Stream<Arguments> quotientMethodSource() {
        return Stream.of(
                Arguments.of(0, 1000, 0),
                Arguments.of(10000, 1000, 10),
                Arguments.of(11500, 1000, 11)
        );
    }
}
