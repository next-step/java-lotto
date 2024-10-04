package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    @Test
    void add() {
        String operand1 = "2";
        String operand2 = "1";
        Assertions.assertThat(StringCalculator.add(operand1 , operand2)).isEqualTo(3);
    }

    @Test
    void subtract() {
        String operand1 = "2";
        String operand2 = "1";
        Assertions.assertThat(StringCalculator.subtract(operand1 , operand2)).isEqualTo(1);
    }

    @Test
    void multiply() {
        String operand1 = "2";
        String operand2 = "3";
        Assertions.assertThat(StringCalculator.multiply(operand1 , operand2)).isEqualTo(6);
    }

    @Test
    void divide() {
        String operand1 = "3";
        String operand2 = "2";
        Assertions.assertThat(StringCalculator.divide(operand1 , operand2)).isEqualTo(1);
    }

}
