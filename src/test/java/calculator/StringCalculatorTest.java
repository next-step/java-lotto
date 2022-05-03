package calculator;

import calculator.model.Formula;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @Test
    void 덧셈을_할_경우() {
        StringCalculator stringCalculator = new StringCalculator(new Formula("2 + 3"));
        assertThat(stringCalculator.start()).isEqualTo(5);
    }

    @Test
    void 뺄셈을_할_경우() {
        StringCalculator stringCalculator = new StringCalculator(new Formula("8 - 3"));
        assertThat(stringCalculator.start()).isEqualTo(5);
    }

    @Test
    void 곱셈을_할_경우() {
        StringCalculator stringCalculator = new StringCalculator(new Formula("2 * 3"));
        assertThat(stringCalculator.start()).isEqualTo(6);
    }

    @Test
    void 나눗셈을_할_경우() {
        StringCalculator stringCalculator = new StringCalculator(new Formula("6 / 3"));
        assertThat(stringCalculator.start()).isEqualTo(2);
    }
    @Test
    void 계산을_성공했을떄() {
        StringCalculator stringCalculator = new StringCalculator(new Formula("2 + 3 * 4 / 2"));
        assertThat(stringCalculator.start()).isEqualTo(10);

        StringCalculator stringCalculator1 = new StringCalculator(new Formula("2 / 1 * 4 + 2"));
        assertThat(stringCalculator1.start()).isEqualTo(10);

        StringCalculator stringCalculator2 = new StringCalculator(new Formula("2 + 5 * 4 / 2"));
        assertThat(stringCalculator2.start()).isEqualTo(14);
    }
}
