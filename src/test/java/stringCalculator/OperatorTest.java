package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import stringCalculator.domain.Operand;
import stringCalculator.domain.Operator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorTest {

    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    public void OperatorTest(String input) {
        assertThatThrownBy(() -> new Operator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 값이 사칙연산 기호가 아닌 경우 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"%", "#", "@"})
    public void OperatorTest_사칙연산기호가_아닌경우(String input) {
        assertThatThrownBy(() -> new Operator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
