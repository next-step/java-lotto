package stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculationTest {
    @Test
    void 덧셈() {
        assertThat(Calculation.add(2, 3)).isEqualTo("5");
    }

    @Test
    void 뺄셈() {
        assertThat(Calculation.subtract(2, 1)).isEqualTo("1");
    }

    @Test
    void 곱셈() {
        assertThat(Calculation.multiply(5, 4)).isEqualTo("20");
    }

    @Test
    void 나눗셈() {
        assertThat(Calculation.divide(20, 2)).isEqualTo("10");
    }

    @ParameterizedTest
    @CsvSource(value = {"+:2:3:5", "-:2:1:1", "*:5:4:20", "/:20:2:10"}, delimiter = ':')
    void 계산_테스트(String operator, String firstOperand, String secondOperand, String answer) {
        assertThat(Calculation.of(operator, firstOperand, secondOperand).calculate()).isEqualTo(answer);
    }
}