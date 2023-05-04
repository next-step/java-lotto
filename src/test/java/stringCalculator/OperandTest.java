package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import stringCalculator.domain.Operand;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperandTest {

    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    public void operandTest(String input) {
        assertThatThrownBy(() -> new Operand(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
