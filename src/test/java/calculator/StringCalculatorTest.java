package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class StringCalculatorTest {

    @Test
    void 입력값_공백() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    StringCalculator.splitAndCalculate(null);
                }).withMessageMatching("입력값이 null 또는 빈 공백 문자입니다.");
    }

    @Test
    void 입력값_빈문자열() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    StringCalculator.splitAndCalculate("");
                }).withMessageMatching("입력값이 null 또는 빈 공백 문자입니다.");
    }
}
