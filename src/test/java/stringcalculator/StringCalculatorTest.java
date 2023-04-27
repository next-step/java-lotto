package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StringCalculatorTest {
    @Test
    void 빈값입력시예외처리() {
        String input1 = null;
        String input2 = "";
        String input3 = " ";
        assertAll(
                () -> assertThatThrownBy(() -> new StringCalculator(input1)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new StringCalculator(input2)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new StringCalculator(input3)).isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Test
    void 숫자와사칙연산구분하여담기() {
        StringCalculator stringCalculator = new StringCalculator("2 + 3 * 4 / 2");
        assertAll(
                () -> assertThat(stringCalculator.getOperator(0)).isEqualTo("+"),
                () -> assertThat(stringCalculator.getOperator(1)).isEqualTo("*"),
                () -> assertThat(stringCalculator.getOperator(2)).isEqualTo("/"),
                () -> assertThat(stringCalculator.getNumber(0)).isEqualTo(2),
                () -> assertThat(stringCalculator.getNumber(1)).isEqualTo(3),
                () -> assertThat(stringCalculator.getNumber(2)).isEqualTo(4),
                () -> assertThat(stringCalculator.getNumber(3)).isEqualTo(2)
        );
    }

    @Test
    void 더하기테스트() {
        StringCalculator stringCalculator = new StringCalculator("3 + 7");
        assertAll(
                () -> assertThat(stringCalculator.calculate()).isEqualTo(10)
        );
    }

    @Test
    void 계산기테스트() {
        StringCalculator stringCalculator = new StringCalculator("2 + 3 * 4 / 2");
        assertAll(
                () -> assertThat(stringCalculator.calculate()).isEqualTo(10)
        );
    }
}
