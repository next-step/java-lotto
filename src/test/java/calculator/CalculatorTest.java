package calculator;

import calculator.delimiter.ColonDelimiter;
import calculator.delimiter.CommaDelimiter;
import calculator.delimiter.CustomDelimiter;
import calculator.delimiter.Delimiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    private static final int ZERO = 0;

    private List<Delimiter> delimiters;
    private Calculator calculator;

    @BeforeEach
    void setup() {
        delimiters = Arrays.asList(
                new CustomDelimiter(),
                new ColonDelimiter(),
                new CommaDelimiter()
        );
        calculator = new Calculator();
    }

    private int calculate(String expression) {
        return calculator.calculate(expression, delimiters);
    }

    @ParameterizedTest
    @MethodSource("provideValidExpressions")
    @DisplayName("계산식 테스트")
    void calculateTest(String expression, int sum) {
        int result = this.calculate(expression);
        assertThat(result).isEqualTo(sum);
    }

    private static Stream<Arguments> provideValidExpressions() {
        return Stream.of(
                Arguments.of("//!\n1!2!3", 6),
                Arguments.of("1,3,6", 10),
                Arguments.of("2:4:6", 12)
        );
    }

    @ParameterizedTest
    @MethodSource("provideNotValidDelimiter")
    @DisplayName("유효하지 않은 구분자 테스트")
    void notValidDelimiterTest(String expression) {
        assertThatThrownBy(() -> this.calculate(expression))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideNotValidDelimiter() {
        return Stream.of(
                Arguments.of("1v2e3"),
                Arguments.of("//!\n1@2!3")
        );
    }

    @ParameterizedTest
    @MethodSource("provideNegativeNumber")
    @DisplayName("음수 테스트")
    void negativeNumberTest(String expression) {
        assertThatThrownBy(() -> this.calculate(expression))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideNegativeNumber() {
        return Stream.of(
                Arguments.of("-1,2,3"),
                Arguments.of("2:-3:-2"),
                Arguments.of("//!\n1!-2!3")
        );
    }

    @Test
    @DisplayName("빈 문자열 반환값 테스트")
    void emptyExpressionTest() {
        int result = this.calculate("");
        assertThat(result).isEqualTo(ZERO);
    }

    @Test
    @DisplayName("null 문자열 반환값 테스트")
    void nullExpressionTest() {
        int result = this.calculate(null);
        assertThat(result).isEqualTo(ZERO);
    }

    @ParameterizedTest
    @MethodSource("provideSingleNumber")
    @DisplayName("단일 문자열 반환값 테스트")
    void singleNumberTest(String expression, int sum) {
        int result = this.calculate(expression);
        assertThat(result).isEqualTo(sum);
    }

    private static Stream<Arguments> provideSingleNumber() {
        return Stream.of(
                Arguments.of("1", 1),
                Arguments.of("3", 3),
                Arguments.of("10", 10)
        );
    }

    @ParameterizedTest
    @MethodSource("provideMultipleDelimiter")
    @DisplayName("다중 구분자 반환값 테스트")
    void multipleDelimiterTest(String expression, int sum) {
        int result = this.calculate(expression);
        assertThat(result).isEqualTo(sum);
    }

    private static Stream<Arguments> provideMultipleDelimiter() {
        return Stream.of(
                Arguments.of("1:3,3", 7),
                Arguments.of("4,5:3", 12),
                Arguments.of("//!\n1!2,3", 6)
        );
    }
}
