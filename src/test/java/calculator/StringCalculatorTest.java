package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {
    @DisplayName("calculate 테스트")
    @Test
    public void calculate() {
        assertThat(StringCalculatorParser.parse("1 + 2 * 3").calculate())
                .isEqualTo(9);

        assertThat(StringCalculatorParser.parse("1 + 2 * 3 - 1 / 2").calculate())
                .isEqualTo(4);
    }

    @DisplayName("calculator 재활용 불가 테스트")
    @Test
    public void calculateRepeat() {
        StringCalculator calculator = StringCalculatorParser.parse("1 + 2 * 3");
        assertThat(calculator.calculate())
                .isEqualTo(9);

        assertThatThrownBy(calculator::calculate)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageStartingWith("this stringCalculator has already been closed");
    }
}