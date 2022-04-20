package stringcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringCalculatorTest {
    
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력값이 null 혹은 공백일 경우 IllegalArgumentException 발생")
    void throwIllegalArgumentExceptionWhenInputNullOrEmpty(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.calculate(input));
    }

}