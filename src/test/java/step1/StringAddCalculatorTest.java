package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("입력 값이 공백")
    void input_empty() {
        assertThat(StringAddCalculator.of().calculate("")).isEqualTo(0);
    }

    @Test
    @DisplayName("입력 값이 null")
    void input_null() {
        assertThat(StringAddCalculator.of().calculate(null)).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "1,2:3",
        "3,2,1",
        "3:1:2",
        "//;\n1;2;3"
    })
    @DisplayName("ok")
    void ok(String input) {
        assertThat(StringAddCalculator.of().calculate(input)).isEqualTo(6);
    }

}
