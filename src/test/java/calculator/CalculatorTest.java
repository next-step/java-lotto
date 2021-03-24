package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

public class CalculatorTest {
    @Test
    void testGetInstance() {
        Calculator calculator = Calculator.getInstance();
        Assertions.assertThat(calculator)
                .isEqualTo(Calculator.getInstance());
    }

    @Test
    void testToNumber() {
        String oneString = "1";
        int one = Calculator.getInstance()
                .toNumber(oneString);
        Assertions.assertThat(one)
                .isEqualTo(1);
    }

    @DisplayName("숫자 이외의 값을 입력할 경우 RuntimeException 을 던진다")
    @Test
    void testToNumber_whenNonNumericString() {
        String nonNumeric = "g";
        Assertions.assertThatThrownBy(
                () -> Calculator.getInstance()
                        .toNumber(nonNumeric))
                .isInstanceOf(RuntimeException.class);
    }


    @DisplayName("음수를 입력한 경우 RuntimeException 을 던진다")
    @Test
    void testAssurePositive_whenNegative() {
        int negative = -1;
        Assertions.assertThatThrownBy(
                () -> Calculator.getInstance()
                        .assurePositive(negative))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void testAssurePositive_whenPositive() {
        int positive = 1;
        Assertions.assertThatCode(() -> Calculator.getInstance()
                .assurePositive(positive))
                .doesNotThrowAnyException();
    }

    @DisplayName("null 이나 \"\" 을 입력하면 0을 리턴한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void testCalculate(String nullOrEmpty) {
        int expected = 0;
        Expression expression = StringAdditionExpression.getExpression(nullOrEmpty);
        int sum = Calculator.getInstance()
                .calculate(expression);
        Assertions.assertThat(sum)
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("providerTestCalculate")
    void testCalculate(String input, int expected) {
        Expression expression = StringAdditionExpression.getExpression(input);
        int sum = Calculator.getInstance()
                .calculate(expression);
        Assertions.assertThat(sum)
                .isEqualTo(expected);
    }

    static Stream<Arguments> providerTestCalculate() {
        return Stream.of(
                Arguments.of("1,2,3", 6),
                Arguments.of("1:2:3", 6),
                Arguments.of("1000", 1000),
                Arguments.of("//n\n1n2n3", 6),
                Arguments.of("//!\n1!2!3", 6)
        );
    }

    @DisplayName("음수나 숫자아닌 문자열을 입력하면 RuntimeException 을 던진다")
    @ParameterizedTest
    @MethodSource("providerTestCalculate_onInvalidInput")
    void testCalculate_onInvalidInput(String input) {
        Expression expression = StringAdditionExpression.getExpression(input);
        Assertions.assertThatThrownBy(() ->
                Calculator.getInstance()
                        .calculate(expression))
                .isInstanceOf(RuntimeException.class);
    }


    static Stream<Arguments> providerTestCalculate_onInvalidInput() {
        return Stream.of(
                Arguments.of("1,-2,3", 6),
                Arguments.of("g", 6),
                Arguments.of("//n\n-3", 6),
                Arguments.of("//!\n1!2!k", 6)
        );
    }

}
