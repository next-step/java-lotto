package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @DisplayName("입력값이 null이나 비어있다면 0을 반환한다.")
    @ParameterizedTest(name = "[{index}] {0} = 0")
    @NullAndEmptySource
    void calculate_emptyInput(String expression) {
        int resultNum = Calculator.calculate(expression);

        assertThat(resultNum).isEqualTo(Calculator.DEFAULT_RESULT);
    }

    @DisplayName("입력값이 하나면 그대로 반환한다.")
    @ParameterizedTest(name = "[{index}] {0} = {0}")
    @ValueSource(ints = {1, 100, 1000})
    void calculate_OneNumber(int number) {
        //given
        String StringNum = String.valueOf(number);

        //when
        int resultNum = Calculator.calculate(StringNum);

        //then
        assertThat(resultNum).isEqualTo(number);
    }

    @DisplayName("커스텀 구분자를 사용할 때 계산")
    @ParameterizedTest(name = "[{index}] {0} = {1}")
    @MethodSource("getCustomExpression")
    void calculateNumbers_withCustomDelimiter(String expression, int expected) {
        //when
        int result = Calculator.calculate(expression);

        //then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> getCustomExpression() {
        return Stream.of(
                Arguments.of("//*\n0:2,3*3", 8),
                Arguments.of("//!\n1!2!100", 103),
                Arguments.of("//@\n1000@100,10:1@24", 1135)
        );
    }

    @DisplayName("잘못된 수식을 입력할 경우 예외를 던진다.")
    @ParameterizedTest(name = "[{index}] {0}")
    @MethodSource("invalidExpression")
    void calculate_invalidExpression(String expression) {
        //when
        assertThatThrownBy(() -> Calculator.calculate(expression))
                .isInstanceOf(RuntimeException.class);
    }

    private static Stream<Arguments> invalidExpression() {
        return Stream.of(
                Arguments.of("//*\n0:2!3*3"),
                Arguments.of("//!\n-1!2!100"),
                Arguments.of("//$\n1000@100,10:1@24"),
                Arguments.of("1000:-1,10:1:24")
        );
    }

}
