package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    @DisplayName("input으로 공백문자열이 들어오는 경우 0이 반환된다.")
    void emptyInput() {
        int result = Calculator.compute("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void commaSeperate() {
        int result = Calculator.compute("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void colonSeperate() {
        int result = Calculator.compute("1:2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void commaAndColonSeperate() {
        int result = Calculator.compute("1,2:3");
        assertThat(result).isEqualTo(6);
    }
}
