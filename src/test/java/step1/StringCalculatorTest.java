package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void 빈_문자열_또는_null_값을_입력할_경우_0을_반환한다() {
        StringCalculator calculator = new StringCalculator();
        String blank = "";

        assertThat(calculator.calculate(blank)).isEqualTo(0);
        assertThat(calculator.calculate(null)).isEqualTo(0);
    }
}
