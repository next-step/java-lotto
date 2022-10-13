package step1;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Deque;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CalculatorTest {

    private static Stream<Arguments> provideWrongOperands() {
        return Stream.of(
            Arguments.of("1*", "+", "2"),
            Arguments.of("1", "+", "2*"),
            Arguments.of("", "+", "2"),
            Arguments.of("1", "+", ""),
            Arguments.of(" ", "+", "2")
        );
    }

    private static Stream<Arguments> provideWrongOperators() {
        return Stream.of(
            Arguments.of("1", "", "2"),
            Arguments.of("1", " ", "2"),
            Arguments.of("1", "&", "2"),
            Arguments.of("1", "?", "2"),
            Arguments.of("1", "3", "2")
        );
    }

    @DisplayName("입력 문자열을 빈 공백 문자로 분리")
    @Test
    void splitTest() {
        String input = "1 + 2 / 1";

        String[] result = Calculator.split(input);

        assertThat(result).containsExactly("1", "+", "2", "/", "1");
    }

    @DisplayName("피연산자 정수로 변환")
    @Test
    void operandToIntTest() {
        String operand = "3";

        int result = Calculator.toInt(operand);

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("피연산자 정수로 변환 중 예외 발생")
    @Test
    void operandToIntExceptionTest() {
        assertThatThrownBy(() -> Calculator.toInt("*1")).isExactlyInstanceOf(NumberFormatException.class);
    }

    @DisplayName("구분한 문자 중 피연산자 수")
    @Test
    void collectOperandsTest() {
        String[] arguments = new String[]{"1", "+", "2", "-", "3"};

        Deque<Integer> operands = Calculator.collectOperands(arguments);

        assertAll(
            () -> assertThat(operands).hasSize(3),
            () -> assertThat(operands).containsExactly(1, 2, 3)
        );
    }

    @DisplayName("피연산자가 정수가 아닌 경우 예외 발생")
    @ParameterizedTest
    @MethodSource("provideWrongOperands")
    void operandNotNumberTest(String firstOperand, String operator, String secondOperand) {
        String[] arguments = new String[]{firstOperand, operator, secondOperand};

        assertThatThrownBy(() -> Calculator.collectOperands(arguments)).isExactlyInstanceOf(NumberFormatException.class);
    }

    @DisplayName("구분한 문자 중 연산자 수집")
    @Test
    void collectOperatorsTest() {
        String[] arguments = new String[]{"1", "+", "2", "-", "3"};

        Deque<Operator> operands = Calculator.collectOperators(arguments);

        assertAll(
            () -> assertThat(operands).hasSize(2),
            () -> assertThat(operands).containsExactly(Operator.PLUS, Operator.MINUS)
        );
    }

    @DisplayName("연산자가 사칙연산 기호가 아닌 경우 예외 발생")
    @ParameterizedTest
    @MethodSource("provideWrongOperators")
    void collectOperatorsTest(String firstOperand, String operator, String secondOperand) {
        String[] arguments = new String[]{firstOperand, operator, secondOperand};

        assertThatThrownBy(() -> Calculator.collectOperators(arguments))
            .isExactlyInstanceOf(IllegalArgumentException.class)
            .hasMessage("피연산자 기호가 아닙니다.");
    }
}
