package string_add_calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("문자열 덧셈 계산기 테스트")
public class StringAddCalculatorTest {

    @DisplayName("입력 값이 null 이거나 비어있는 0을 반환한다.")
    @NullAndEmptySource
    @ParameterizedTest
    void returnZeroWhenInputIsNullOrEmpty(String inputString) {
        StringAddCalculator stringAddCalculator = new StringAddCalculator();

        assertThat(stringAddCalculator.calculate(inputString)).isZero();
    }
}
