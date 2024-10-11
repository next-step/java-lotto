package calculator.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperandsTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 피연산자는_필수다(String[] operands) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Operands(operands))
                .withMessage("피연산자를 입력해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "가", " ", " 1", "2 ", " 3 ", "4 5"})
    void 피연산자는_숫자다(String operand) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Operands(operand))
                .withMessage("숫자를 입력해 주세요.");
    }
}
