package StringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
public class CalculatorTest {

    @Test
    @DisplayName("계산기 테스트")
    void calculatorReturnsRightResult() {
        Calculator cal = new Calculator();
        WholeNumber actual = cal.calculate("1,2:3");
        WholeNumber expected = new WholeNumber(6);
        assertThat(actual).isEqualTo(expected);
    }
}
