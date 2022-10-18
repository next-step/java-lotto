package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class StringCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void 계산(List<String> inputString, int result) {
        Assertions.assertThat(new StringCalculator(inputString).calculate()).isEqualTo(result);
    }

    static Stream<Arguments> 계산() {
        return Stream.of(
                Arguments.arguments(List.of("2", "+", "3", "*", "4", "/", "2"), 10),
                Arguments.arguments(List.of("2", "+", "3", "*", "4", "/"), 20),
                Arguments.arguments(List.of("2", "+", ""), 2)
        );
    }
}
