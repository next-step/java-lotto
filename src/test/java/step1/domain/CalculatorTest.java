package step1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("계산 성공")
    void calculateSuccess() {
        String[] parsedExpression = new String[5];
        parsedExpression[0] = "5";
        parsedExpression[1] = "*";
        parsedExpression[2] = "3";
        parsedExpression[3] = "/";
        parsedExpression[4] = "2";

        Calculator calculator = new Calculator();

        assertThat(calculator.calculateResult(parsedExpression))
                .isEqualTo(7);
    }
}
