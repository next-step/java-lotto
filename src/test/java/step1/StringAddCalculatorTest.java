package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("입력 값이 공백")
    void input_empty() {
        assertThatNullPointerException().isThrownBy(() -> StringAddCalculator.of().calculate(new InputString("")));
    }

    @Test
    @DisplayName("입력 값이 null")
    void input_null() {
        assertThatNullPointerException().isThrownBy(() -> StringAddCalculator.of().calculate(new InputString(null)));
    }

}
