package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ArithmeticOperatorTest {

    @DisplayName("올바른 사칙연산 기호라면, 해당하는 Enum 값을 반환해야 한다.")
    @ParameterizedTest
    @MethodSource("provideSymbols")
    void from_givenCorrectSymbol(String symbol, ArithmeticOperator expected) {
        assertThat(ArithmeticOperator.from(symbol)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideSymbols() {
        return Stream.of(
                Arguments.of("+", ArithmeticOperator.PLUS),
                Arguments.of("-", ArithmeticOperator.MINUS),
                Arguments.of("*", ArithmeticOperator.MULTIPLY),
                Arguments.of("/", ArithmeticOperator.DIVIDE)
        );
    }

    @DisplayName("올바르지 않은 사칙연산 기호라면, 예외가 발생해야 한다.")
    @Test
    void from_givenIncorrectSymbol() {
        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(() -> ArithmeticOperator.from("a"));
    }

}
