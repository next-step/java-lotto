package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {
    @Test
    void stringAddCalculatorTest() {
        StringAddCalculator calculator = new StringAddCalculator("1:2:3");

        assertThat(new StringAddCalculato)
    }

    @Test
    void seperateTest() {
        StringAddCalculator calculator = new StringAddCalculator("1:2:3");
        assertThat(calculator.seperateByDelimiter(":")).containsExactly("1", "2", "3");
    }
}
