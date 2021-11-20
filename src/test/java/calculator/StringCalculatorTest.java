package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    @DisplayName("숫자의 합, 2개")
    void sum2() {
        String data = "1,2";

        Number result = StringCalculator.sum(data);

        assertThat(result)
                .isEqualTo(new Number(3));
    }

    @Test
    @DisplayName("숫자의 합, 3개")
    void sum3() {
        String data = "1,2,3";

        Number result = StringCalculator.sum(data);

        assertThat(result)
                .isEqualTo(new Number(6));
    }

    @Test
    @DisplayName("숫자의 합, 3개 혼합 구분자")
    void sum3Mix() {
        String data = "1,2:3";

        Number result = StringCalculator.sum(data);

        assertThat(result)
                .isEqualTo(new Number(6));
    }
}
