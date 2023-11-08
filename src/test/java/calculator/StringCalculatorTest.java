package calculator;

import calculator.domain.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    @DisplayName("사친연산 수행 결과를 확인한다")
    void 사칙연산_결과_확인() {
        String[] textArray = {"2", "+", "10", "/", "3", "+", "6", "/", "3"};

        StringCalculator stringCalculator = new StringCalculator(textArray);
        int result = stringCalculator.startOperation();

        assertThat(result).isEqualTo(3);

    }
}

