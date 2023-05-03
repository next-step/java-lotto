package calculator;

import calculator.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @DisplayName("문자열 계산기 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2 : 10.0", "1 + 9 * 5 / 5 : 10.0", "10 + 6 - 1 / 2 : 7.5"}, delimiter = ':')
    void calculate(String input, Double expected) {
        InputView inputView = new InputView(input);
        List<Double> operands = inputView.getOperands();
        List<String> operators = inputView.getOperators();
        Double result = StringCalculator.calculate(operands, operators);
        assertThat(result).isEqualTo(expected);
    }
}
