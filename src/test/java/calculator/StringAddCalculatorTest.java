package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {
    private StringAddCalculator stringAddCalculator;

    @BeforeEach
    void setUp() {
        stringAddCalculator = new StringAddCalculator();
    }

    @Test
    void calculateCreate() {
        StringAddCalculator calculator = new StringAddCalculator("1,2");
        assertThat(calculator).isEqualTo(new StringAddCalculator("1,2"));
    }

    @Test
    void emptyOrNullValidate() {
        assertThat(stringAddCalculator.add("")).isEqualTo(0);
        assertThat(stringAddCalculator.add(null)).isEqualTo(0);
    }
}
