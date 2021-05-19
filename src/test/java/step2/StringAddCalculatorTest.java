package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {
    private StringAddCalculator stringAddCalculator;

    @BeforeEach
    void initStringAddCalculator() {
        stringAddCalculator = new StringAddCalculator();
    }

    @Test
    @DisplayName("빈 문자열, null 값 입력 테스트")
    void emptyNullInput_ShouldBeZero() {
        assertThat(stringAddCalculator.calculate("")).isEqualTo(0);
        assertThat(stringAddCalculator.calculate(null)).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나 입력 테스트")
    void oneInput_shouldBeOneInput() {
        assertThat(stringAddCalculator.calculate("1")).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("계산 테스트")
    @ValueSource(strings = {"1,5", "1,2,3", "1:2:3", "1,2:3", "1:1:2,2", "//;\n1;2;3", "//;\n2;2;2"})
    void sum_shouldBeEachPlus(String input) {
        assertThat(stringAddCalculator.calculate(input)).isEqualTo(6);
    }
}
