package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {
    @DisplayName("stringAddCalculator 생성 테스트")
    @Test
    void stringAddCalculatorTest() {
        StringAddCalculator calculator = new StringAddCalculator("1:2:3");

        assertThat(new StringAddCalculator("1:2:3")).isEqualTo(calculator);
    }

    @Test
    void seperateTest() {
        StringAddCalculator calculator = new StringAddCalculator("1:2:3");
        assertThat(calculator.seperateByDelimiter(":")).containsExactly("1", "2", "3");
    }
}
