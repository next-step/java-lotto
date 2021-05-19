package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    StringAddCalculator calculator;
    @BeforeEach
    public void setUp() {
        calculator = new StringAddCalculator();
    }
    @Test
    @DisplayName("쉼표,콜론으로 구분된 문자열 계산")
    public void splitWithDefaultDelimiter() {
        String data1 = "1,2,3";
        String data2 = "1,2;3";
        int result1 = calculator.calculate(data1);
        int result2 = calculator.calculate(data2);
        assertThat(result1).isEqualTo(6);
        assertThat(result2).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀한 구분 문자열 지정하여 계산")
    public void splitWithCustomDelimiter() {
        String customDelimiter = "w";
        String data1 = "//w\n1w2w3";
    }
}
