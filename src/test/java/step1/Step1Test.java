package step1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.*;

public class Step1Test {

    @ParameterizedTest
    @ValueSource(strings = {"4 + 2"})
    public void 덧셈(String input) {
        StringCalculator stringCalculator = new StringCalculator(input);
        assertThat(stringCalculator.calculate()).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"4 - 2"})
    public void 뺄셈(String input) {
        StringCalculator stringCalculator = new StringCalculator(input);
        assertThat(stringCalculator.calculate()).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"4 * 2"})
    public void 곱셈(String input) {
        StringCalculator stringCalculator = new StringCalculator(input);
        assertThat(stringCalculator.calculate()).isEqualTo(8);
    }

    @ParameterizedTest
    @ValueSource(strings = {"6 / 3"})
    public void 나누셈(String input) {
        StringCalculator stringCalculator = new StringCalculator(input);
        assertThat(stringCalculator.calculate()).isEqualTo(2);
    }


    @ParameterizedTest
    @NullAndEmptySource
    public void 입력값_빈값_NULL_검증(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new StringCalculator(input);
                }).withMessageMatching("문자열이 빈값일 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 ^ 3 * 4 / 2", "2 + 3 % 4 / 2"})
    public void 입력값_사칙연산_문자열_검증(String input) {
        assertThatIllegalStateException()
                .isThrownBy(() -> {
                    new StringCalculator(input);
                }).withMessageMatching("알 수 없는 연산자입니다.");
    }

    @Test
    public void 입력값사칙연산검증() {
        StringCalculator stringCalculator = new StringCalculator("2 + 3 * 4 / 2");
        assertThat(stringCalculator.calculate()).isEqualTo(10);
    }
}
