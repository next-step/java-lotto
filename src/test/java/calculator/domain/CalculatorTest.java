package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static calculator.domain.OperatorType.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {

    @DisplayName("연산자와 피연산자를 전달받으면 Calculator 객체를 생성한다.")
    @Test
    void create() {
        Operands operands = new Operands(List.of(new OperandNumber(3), new OperandNumber(3), new OperandNumber(2), new OperandNumber(4), new OperandNumber(2)));
        Operators operators = new Operators(List.of(PLUS, MINUS, TIMES, DIVISION));

        assertThat(Calculator.create("3 + 3 - 2 * 4 / 2"))
                .extracting("operands", "operators")
                .contains(operands, operators);
    }

    @DisplayName("입력 값이 null이거나 빈 공백 문자일 때 IllegalArgumentException을 발생시킨다.")
    @ParameterizedTest
    @NullAndEmptySource
    void throw_IllegalArgumentException_when_input_is_null_or_blank(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.create(input))
                .withMessage("입력 값이 null이거나 빈 공백 문자일수 없습니다.");
    }

    @DisplayName("사칙 연산 계산한다.")
    @Test
    void return_calculated_result() {
        Calculator calculator = Calculator.create("3 + 3 - 2 * 4 / 2");

        assertThat(calculator.calculate()).isEqualTo(new OperandNumber(8));
    }
}
