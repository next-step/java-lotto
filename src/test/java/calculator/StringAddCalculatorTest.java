package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringAddCalculatorTest {
    private StringAddCalculator stringAddCalculator;
    private StringInput stringInput;

    @BeforeEach
    void setUp() {
        stringAddCalculator = new StringAddCalculator();
        stringInput = new StringInput();
    }

    @Test
    void calculateCreateTest() {
        StringAddCalculator calculator = new StringAddCalculator();
        assertThat(calculator).isEqualTo(new StringAddCalculator());
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
        assertThat(stringInput.basicSplit("1,2")).hasSize(2);
        assertThat(stringInput.basicSplit("1,2")).contains("1", "2");
    }

    @Test
    void colonSplitWithCommaSplitTest() {
        assertThat(stringInput.inputSplitWithCustom("//;\n1;2;3")).hasSize(3);
    }

    @Test
    void customTokenTest() {
        assertThat(stringAddCalculator.add("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void exceptionTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringAddCalculator.add("-1,2,3");
        });
    }
}
