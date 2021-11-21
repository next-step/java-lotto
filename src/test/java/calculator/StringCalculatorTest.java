package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    @DisplayName("숫자의 합, 2개")
    void sum2() {
        String data = "1,2";

        assertThat(StringCalculator.sum(data))
                .isEqualTo(3);
    }

    @Test
    @DisplayName("숫자의 합, 3개")
    void sum3() {
        String data = "0,3,3";

        assertThat(StringCalculator.sum(data))
                .isEqualTo(6);
    }

    @Test
    @DisplayName("숫자의 합, 3개 혼합 구분자")
    void sum3Mix() {
        String data = "1,2:3";

        assertThat(StringCalculator.sum(data))
                .isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자 지정")
    void sumAnotherSeparator() {
        String data = "//;\n1;2;3";

        assertThat(StringCalculator.sum(data))
                .isEqualTo(6);
    }

    @Test
    @DisplayName("null 또는 빈 문자 시 0 리턴")
    void sumWhenInputNullOrEmpty() {
        assertThat(StringCalculator.sum(null))
                .isEqualTo(0);
        assertThat(StringCalculator.sum(""))
                .isEqualTo(0);
    }
}
