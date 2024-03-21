package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    @DisplayName("입력한 문자열에 따라 연산이 수행된다")
    void run() {
        Numbers numbers = Numbers.create(new String[]{"1", "+", "2", "*", "4", "/", "3"});
        Symbols symbols = Symbols.create(new String[]{"1", "+", "2", "*", "4", "/", "3"});

        Calculator cal = new Calculator(numbers, symbols);
        double result = cal.run();
        assertThat(result).isEqualTo(4.0);
    }
}
