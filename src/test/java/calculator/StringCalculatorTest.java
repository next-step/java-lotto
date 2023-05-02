package calculator;

import calculator.domain.StringCalculator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void 입력은_공백으로_분리() {
        String input = "2 + 3 * 4 / 2";
        List<String> tokens = StringCalculator.devide(input);
        assertThat(tokens).hasSameElementsAs(List.of("2", "+", "3", "*", "4", "/", "2"));
    }

    @Test
    void 분리된_문자를_입력순으로_계산() {
        List<String> tokens = List.of("2", "+", "3", "*", "4", "/", "2");
        int result = StringCalculator.calculate(tokens);
        assertThat(result).isEqualTo(10);
    }
}
