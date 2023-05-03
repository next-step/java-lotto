package calculator;

import calculator.domain.StringCalculator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    void 더하기() {
        List<String> tokens = List.of("2", "+", "3");
        int result = StringCalculator.calculate(tokens);
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 빼기() {
        List<String> tokens = List.of("2", "-", "7");
        int result = StringCalculator.calculate(tokens);
        assertThat(result).isEqualTo(-5);
    }

    @Test
    void 곱하기() {
        List<String> tokens = List.of("0", "*", "7");
        int result = StringCalculator.calculate(tokens);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 나누기() {
        List<String> tokens = List.of("9", "/", "2");
        int result = StringCalculator.calculate(tokens);
        assertThat(result).isEqualTo(4);
    }

    @Test
    void 분리된_문자를_입력순으로_계산() {
        List<String> tokens = List.of("2", "+", "3", "*", "4", "/", "2");
        int result = StringCalculator.calculate(tokens);
        assertThat(result).isEqualTo(10);
    }

    @Test
    void 잘못된_사칙연산() {
        List<String> tokens = List.of("2", "--", "3", "*", "4", "/", "2");
        assertThatThrownBy(() -> StringCalculator.calculate(tokens))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력입니다.");
    }

}
