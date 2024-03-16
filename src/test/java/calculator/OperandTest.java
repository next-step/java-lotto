package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperandTest {
    @ParameterizedTest
    @ValueSource(strings = {"abc", "+123", "+", "-", "*", "/"})
    @DisplayName("Operand 인스턴스 생성 시 숫자가 아닌 문자열이 파라미터로 전달되는 경우 IllegalArgumentException이 발생한다.")
    void testInstanceCreationFail(String value) {
        assertThatThrownBy(() -> Operand.newOperand(value))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}