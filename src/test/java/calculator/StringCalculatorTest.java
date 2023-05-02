package calculator;

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
}
