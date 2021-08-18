package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringCalculatorTest {

    @Test
    @DisplayName("쉼표와 콜론을 구분자로 문자열을 분리하는지 테스트")
    void splitString() {
        String[] result = StringCalculator.splitString("1,2");
        assertThat(result).isEqualTo(new String[]{"1", "2"});

        result = StringCalculator.splitString("2:3");
        assertThat(result).isEqualTo(new String[]{"2", "3"});

        result = StringCalculator.splitString(null);
        assertThat(result).isEqualTo(new String[]{"0"});

        result = StringCalculator.splitString("");
        assertThat(result).isEqualTo(new String[]{"0"});
    }

    @Test
    @DisplayName("커스텀 구분자로 문자열을 분리하는지 테스트")
    void splitStringByCustom() {
        String[] result = StringCalculator.splitString("//%\n1%3%5");
        assertThat(result).isEqualTo(new String[]{"1", "3", "5"});
    }

    @Test
    @DisplayName("숫자 문자를 Int값으로 바꾸는지 테스트")
    void parseInt() {
        int result = StringCalculator.parseInt("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("빈 문자열이나 null로 전달될 경우 0으로 반환하는지 테스트")
    void parseIntToZero() {
        int result = StringCalculator.parseInt("");
        assertThat(result).isEqualTo(0);

        result = StringCalculator.parseInt(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자가 아닌 값이나 음수가 전달될 경우 RuntimeException이 나는지 테스트")
    void parseIntNotPositiveNumber() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            StringCalculator.parseInt("-1");
        });

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            StringCalculator.parseInt("a");
        });
    }

    @Test
    @DisplayName("덧셈이 잘 되는지 테스트")
    void sum() {
        int result = StringCalculator.sum("1,2,3");
        assertThat(result).isEqualTo(6);

        result = StringCalculator.sum("2,4:6");
        assertThat(result).isEqualTo(12);

        result = StringCalculator.sum("3:6:9");
        assertThat(result).isEqualTo(18);

        result = StringCalculator.sum("//#\n5#10#15");
        assertThat(result).isEqualTo(30);

        result = StringCalculator.sum("7");
        assertThat(result).isEqualTo(7);
    }
}

