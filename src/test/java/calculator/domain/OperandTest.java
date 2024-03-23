package calculator.domain;

import static calculator.config.CalculatorExceptionMessage.OPERAND_SHOULD_BE_INTEGER_FORMAT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OperandTest {

    @Test
    @DisplayName("피연산자를 정수로 변환하여 저장한다.")
    void Operand_IntegerNumber() {
        final String integerNumber = "1";
        final Operand operand = Operand.from(integerNumber);

        assertThat(operand.number())
                .isEqualTo(Integer.parseInt(integerNumber));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\n", "     ", "a", "%", "1ab"})
    @DisplayName("피연산자가 정수형이 아닌 경우 예외를 던진다.")
    void Operand_NotIntegerNumber_Exception(final String notIntegerNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operand.from(notIntegerNumber))
                .withMessage(OPERAND_SHOULD_BE_INTEGER_FORMAT.message(notIntegerNumber));
    }

    @Test
    @DisplayName("같은 피연산자 정수값을 가진 두 객체는 서로 참조는 다르나 동등한 객체로 판단한다.")
    void Equals_SameNumber() {
        final int number = 1;
        final Operand actual = new Operand(number);
        final Operand expected = new Operand(number);

        assertThat(actual)
                .isNotSameAs(expected)
                .isEqualTo(expected);
    }
}
