package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1000})
    void create(int money) {
        // given
        Money self = new Money(money);

        // when
        Money other = new Money(money);

        // then
        assertThat(self).isEqualTo(other);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1000, -1})
    void invalid_create(int money) {
        // given
        assertThatThrownBy(() -> {
            new Money(money);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("quotientSource")
    @DisplayName("Money 는 다른 Money 와 협력하여 몫을 구할 수 있다.")
    void quotient(int numerator, int denominator, int result) {
        // given
        Money self = new Money(numerator);

        // when
        Money other = new Money(denominator);

        // then
        assertThat(self.quotient(other)).isEqualTo(result);
    }

    static Stream<Arguments> quotientSource() {
        return Stream.of(
                Arguments.of(10000, 1000, 10),
                Arguments.of(10500, 1000, 10),
                Arguments.of(11000, 1000, 11)
        );
    }

    @ParameterizedTest
    @MethodSource("invalid_quotientSource")
    @DisplayName("Money 는 다른 Money 와 협력하여 몫을 구할 수 있다. 단, 0으로 나누는 경우는 불가능하다.")
    void invalid_quotient(int numerator, int denominator) {
        // given
        Money self = new Money(numerator);

        // when
        Money other = new Money(denominator);

        // then
        assertThatThrownBy(() -> {
            self.quotient(other);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> invalid_quotientSource() {
        return Stream.of(
                Arguments.of(10000, 0)
        );
    }
}
