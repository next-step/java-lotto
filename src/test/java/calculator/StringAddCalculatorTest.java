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
    void calculateCreateTest() {
        StringAddCalculator calculator = new StringAddCalculator("1,2");
        assertThat(calculator).isEqualTo(new StringAddCalculator("1,2"));
    }

    @Test
    void emptyOrNullValidateTest() {
        assertThat(stringAddCalculator.add("")).isEqualTo(0);
        assertThat(stringAddCalculator.add(null)).isEqualTo(0);
    }

    @Test
    void onceValueTest() {
        assertThat(stringAddCalculator.add("5")).isEqualTo(5);
    }

    @Test
    void sumCalculateTest() {
        assertThat(stringAddCalculator.add("1,2:3")).isEqualTo(6);
    }

    @Test
    void commaSplitTest() {
        assertThat(stringAddCalculator.numberSplit("1,2")).hasSize(2);
        assertThat(stringAddCalculator.numberSplit("1,2")).contains("1", "2");
    }

    @Test
    void colonSplitWithCommaSplitTest() {
        assertThat(stringAddCalculator.numberSplit("1:3,2")).hasSize(3);
    }
}
