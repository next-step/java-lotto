package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
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

    @Test
    void 입력값_사칙연산기호_아닌경우() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.splitAndCalculate("1 X 3");
        }).withMessageMatching("사칙연산 기호가 아닌 문자는 허용되지 않습니다.");
    }
}
