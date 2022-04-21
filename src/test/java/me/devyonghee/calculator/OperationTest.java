package me.devyonghee.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("연산 종류")
class OperationTest {

    @ParameterizedTest(name = "[{index}] {0} 의 기호로 연산을 가져오면 {1}")
    @DisplayName("연산 기호로 연산 종류 가져오기")
    @CsvSource({"+,PLUS", "-,MINUS", "*,MULTIPLY", "/,DIVIDE"})
    void of(String symbol, Operation expected) {
        assertThat(Operation.of(symbol)).isEqualTo(expected);
    }

    @Test
    @DisplayName("존재하지 않는 기호라면 IllegalArgumentException")
    void of_notSupported_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Operation.of(""));
    }

    @ParameterizedTest(name = "[{index}] {1} 와 {2} 을 {0} 연산을 하면 {3}")
    @DisplayName("더하기 계산")
    @MethodSource
    void calculatedNumber(Operation operation, Number number, Number target, Number expected) {
        assertThat(operation.calculatedNumber(number, target)).isEqualTo(expected);
    }

    private static Stream<Arguments> calculatedNumber() {
        return Stream.of(
                Arguments.of(Operation.PLUS, Number.ONE, Number.ONE, Number.from("2")),
                Arguments.of(Operation.MINUS, Number.ONE, Number.ONE, Number.ZERO),
                Arguments.of(Operation.MULTIPLY, Number.ONE, Number.ZERO, Number.ZERO),
                Arguments.of(Operation.DIVIDE, Number.ZERO, Number.ONE, Number.ZERO)
        );
    }
}
