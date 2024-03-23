package calculator.domain;

import static calculator.config.CalculatorExceptionMessage.DIVISOR_CANNOT_BE_ZERO;
import static calculator.config.CalculatorExceptionMessage.OPERATOR_SHOULD_BE_ARITHMETIC_SYMBOL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class OperatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    @DisplayName("사칙 연산자를 저장한다.")
    void Operator_ArithmeticSymbol(final String arithmeticSymbol) {
        final Operator operator = Operator.from(arithmeticSymbol);

        assertThat(operator.symbol())
                .isEqualTo(arithmeticSymbol);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\n", "     ", "a", "%", "1"})
    @DisplayName("연산자가 사칙 연산 기호(+, -, *, /) 이외의 문자인 경우 예외를 던진다.")
    void Operator_NotArithmeticSymbol_Exception(final String notArithmeticSymbol) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.from(notArithmeticSymbol))
                .withMessage(OPERATOR_SHOULD_BE_ARITHMETIC_SYMBOL.message(notArithmeticSymbol));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,+,3", "2,4,-,-2", "2,5,*,10", "4,2,/,2"})
    @DisplayName("두 피연산자를 받아 사칙연산을 수행하고 결과를 반환한다.")
    void Calculate_TwoOperands(
            final int leftNumber,
            final int rightNumber,
            final String symbol,
            final int result
    ) {
        final Operator operator = Operator.from(symbol);

        assertThat(operator.calculate(new Operand(leftNumber), new Operand(rightNumber)))
                .isEqualTo(new Operand(result));
    }

    @Test
    @DisplayName("나눗셈 연산에서 0으로 나누는 경우 예외를 던진다.")
    void Calculate_ZeroDivisor_Exception() {
        final Operand dividend = Operand.from("1");
        final Operand zeroDivisor = Operand.from("0");
        final Operator division = Operator.from("/");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> division.calculate(dividend, zeroDivisor))
                .withMessage(DIVISOR_CANNOT_BE_ZERO.message());
    }

    @ParameterizedTest
    @CsvSource(value = {"+,true", "-,true", "*,true", "/,true", "%,false", "$,false", "1,false"})
    @DisplayName("isOperator 메서드는 전달한 기호가 사칙 연산인지 판단한다.")
    void IsOperator_TrueOrFalse(final String symbol, final boolean isOperator) {
        assertThat(Operator.isOperator(symbol))
                .isEqualTo(isOperator);
    }
}
