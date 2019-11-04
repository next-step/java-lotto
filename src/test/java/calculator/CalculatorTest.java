package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("공백이 들어오면 0으로 리턴한다. ")
    void add(String input) {
        assertThat(StringCalculate.add(input)).isZero();
    }

    @ParameterizedTest
    @MethodSource(value = "provideInput")
    @DisplayName("공백이 들어오면 0으로 리턴한다. ")
    void addResult(String input, int expected) {
        assertThat(StringCalculate.add(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideInput() {
        return Stream.of(
                Arguments.of("1,2,3", 6),
                Arguments.of("1,2:3", 6),
                Arguments.of("//;\\n1;2;3", 6)
        );
    }
}
