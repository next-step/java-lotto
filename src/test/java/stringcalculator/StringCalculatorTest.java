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
                () -> assertThatThrownBy(() -> new StringCalculater(input1)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new StringCalculater(input2)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new StringCalculater(input3)).isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Test
    void 숫자와사칙연산구분하여담기() {
        StringCalculater stringCalculater = new StringCalculater("2 + 3 * 4 / 2");
        assertAll(
                () -> assertThat(stringCalculater.getOperator(0)).isEqualTo("+"),
                () -> assertThat(stringCalculater.getOperator(1)).isEqualTo("*"),
                () -> assertThat(stringCalculater.getOperator(2)).isEqualTo("/"),
                () -> assertThat(stringCalculater.getNumber(0)).isEqualTo(2),
                () -> assertThat(stringCalculater.getNumber(1)).isEqualTo(3),
                () -> assertThat(stringCalculater.getNumber(2)).isEqualTo(4),
                () -> assertThat(stringCalculater.getNumber(3)).isEqualTo(2)
        );
    }

    @Test
    void 더하기테스트() {
        StringCalculater stringCalculater = new StringCalculater("3 + 7");
        assertAll(
                () -> assertThat(stringCalculater.calculate()).isEqualTo(10)
        );
    }

    @Test
    void 계산기테스트() {
        StringCalculater stringCalculater = new StringCalculater("2 + 3 * 4 / 2");
        assertAll(
                () -> assertThat(stringCalculater.calculate()).isEqualTo(10)
        );
    }
}
