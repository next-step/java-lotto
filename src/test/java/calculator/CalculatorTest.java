package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @ParameterizedTest
    @MethodSource("normalCaseProvider")
    void 정상_계산(String text, int expected) {
        assertThat(Calculator.calculate(text)).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"1 ) 2", "1 + 2 $ 3", "s + 1", "s"})
    void 비정상_계산(String text) {
        assertThatThrownBy(() -> Calculator.calculate(text))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> normalCaseProvider() {
        return Stream.of(
                Arguments.of("10", 10),
                Arguments.of("11 + 2", 13),
                Arguments.of("1 / 1", 1),
                Arguments.of("3 * 2 / 3", 2),
                Arguments.of("1 * 2 + 4 / 2", 3),
                Arguments.of("1 * 2 + 3 - 3", 2),
                Arguments.of("1   *  2", 2),
                Arguments.of("1   *  2   / 2   +   1", 2)
        );
    }

}
