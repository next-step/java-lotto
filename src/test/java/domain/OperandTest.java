package domain;

import static config.CalculatorExceptionMessage.OPERAND_SHOULD_BE_INTEGER_FORMAT;
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
    void Operand_NotIntegerNumber(final String notIntegerNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operand.from(notIntegerNumber))
                .withMessage(OPERAND_SHOULD_BE_INTEGER_FORMAT.message(notIntegerNumber));
    }
}
