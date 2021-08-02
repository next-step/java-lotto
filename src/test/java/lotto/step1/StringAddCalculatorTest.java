package lotto.step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringAddCalculatorTest {

    @Test
    @DisplayName("빈 문자열이나 null 일 때 0 반환")
    void calculator_null() {
        String text ="";
        StringAddCalculator stringAddCalculator = new StringAddCalculator(text);
        int result = stringAddCalculator.splitAndSum();
        Assertions.assertThat(result).isEqualTo(0);
    }
}