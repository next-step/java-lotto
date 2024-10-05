package stringcalculator.domain.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.exception.StringCalculatorIllegalArgumentException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class OperatorFactoryTest {

    @DisplayName("사칙 연산에 해당하는 객체를 찾을 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void getOperation(String input) {
        Operator operator = OperatorFactory.getOperation(input);

        if (input.equals("+")) {
            assertInstanceOf(Addition.class, operator, "덧셈 연산자");
        } else if (input.equals("-")) {
            assertInstanceOf(Subtraction.class, operator, "뺄셈 연산자");
        } else if (input.equals("*")) {
            assertInstanceOf(Multiplication.class, operator, "곱셈 연산자");
        } else if (input.equals("/")) {
            assertInstanceOf(Division.class, operator, "나눗셈 연산자");
        }
    }

    @DisplayName("사칙 연산에 해당하는 객체를 찾을 수 없으면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"^", "&", "(", ")"})
    void operationNotFound(String input) {
        assertThatThrownBy(() -> OperatorFactory.getOperation(input))
                .isInstanceOf(StringCalculatorIllegalArgumentException.class);
    }
}