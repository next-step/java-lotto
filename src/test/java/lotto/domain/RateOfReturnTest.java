package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RateOfReturnTest {
    @DisplayName("투자금액이 0원이라면 예외를 발생시킨다.")
    @Test
    void instance_when_invalid_investment() {
        assertThatThrownBy(() -> new RateOfReturn(Money.ZERO, new Money(100)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("The investment must be greater than zero.");
    }

    @DisplayName("수익률을 리턴한다.")
    @ParameterizedTest
    @MethodSource("valueSet")
    void value(Money investment, Money income, double expected) {
        assertThat(new RateOfReturn(investment, income).value()).isEqualTo(expected);
    }
    
    private static Stream<Arguments> valueSet() {
        return Stream.of(
                Arguments.arguments(new Money(10_000), new Money(10_000), 1),
                Arguments.arguments(new Money(10_000), Money.ZERO, 0),
                Arguments.arguments(new Money(10_000), new Money(5_000), 0.5)
        );
    }
}
