package study.lotto.step1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;


class OperatorTest {
    @ParameterizedTest(name = "[{index}/4] {displayName}: {arguments}")
    @MethodSource("signAndOperator")
    @DisplayName("연산자 기호로부터 Operator enum 반환")
    void Operator_from_sign(String sign, Operator expectedOperator) {
        assertThat(Operator.of(sign)).isEqualTo(expectedOperator);
    }

    @Test
    void invalid_sign_then_throw_IllegalArgumentException() {
        // given
        String invalidSign = "!";

        // when, then
        assertThatThrownBy(() -> Operator.of(invalidSign))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사칙연산 기호가 아닙니다: " + invalidSign);
    }

    @Test
    void add() {
        // given
        Operand firstOperand = new Operand("10");
        Operand secondOperand = new Operand("20");

        // when
        Operand added = Operator.ADD.calculate(firstOperand, secondOperand);

        // then
        assertThat(added).isEqualTo(new Operand("30"));
    }

    @Test
    void subtract() {
        // given
        Operand firstOperand = new Operand("30");
        Operand secondOperand = new Operand("20");

        // when
        Operand subtracted = Operator.SUBTRACT.calculate(firstOperand, secondOperand);

        // then
        assertThat(subtracted).isEqualTo(new Operand("10"));
    }

    @Test
    void multiply() {
        // given
        Operand firstOperand = new Operand("30");
        Operand secondOperand = new Operand("20");

        // when
        Operand multiplied = Operator.MULTIPLY.calculate(firstOperand, secondOperand);

        // then
        assertThat(multiplied).isEqualTo(new Operand("600"));
    }

    @Test
    void divide() {
        // given
        Operand firstOperand = new Operand("6");
        Operand secondOperand = new Operand("3");

        // when
        Operand divided = Operator.DIVIDE.calculate(firstOperand, secondOperand);

        // then
        assertThat(divided).isEqualTo(new Operand("2"));
    }

    @DisplayName("나눗셈 연산의 결과가 정수가 아닐 경우, IllegalArgumentException 예외 발생")
    @Test
    void when_divide_result_is_not_integer_then_throw_IllegalArgumentException() {
        // given
        Operand firstOperand = new Operand("3");
        Operand secondOperand = new Operand("2");

        // when, then
        assertThatThrownBy(() -> Operator.DIVIDE.calculate(firstOperand, secondOperand))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("나눗셈의 결과가 정수가 아닙니다: 3/2");
    }

    private static Stream<Arguments> signAndOperator() {
        return Stream.of(
                Arguments.of("+", Operator.ADD),
                Arguments.of("-", Operator.SUBTRACT),
                Arguments.of("*", Operator.MULTIPLY),
                Arguments.of("/", Operator.DIVIDE)
        );
    }
}