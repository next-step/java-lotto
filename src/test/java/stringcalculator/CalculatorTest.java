package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    @DisplayName("두 숫자를 더한다.")
    void addTest() {
        //given
        int a = 1;
        int b = 2;
        final Calculator calculator = new Calculator();

        //when
        int result = calculator.add(a, b);

        //then
        assertThat(result).isEqualTo(3);
    }

}
