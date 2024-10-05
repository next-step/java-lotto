package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stringcalculator.view.InputView;
import stringcalculator.view.ResultView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @DisplayName("사용자의 입력을 공백으로 나눌 수 있다.")
    @Test
    void calculate() {
        List<String> input = List.of("2", "+", "3", "*", "4", "/", "2");
        StringCalculator stringCalculator = new StringCalculator(new InputView(), new ResultView());

        int result = stringCalculator.calculate(input);

        assertThat(result).isEqualTo(10);
    }
}
