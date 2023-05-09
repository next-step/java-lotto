package calculator;

import calculator.domain.Operand;
import calculator.domain.Operator;
import calculator.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @DisplayName("문자열 계산기 테스트")
    @ParameterizedTest
    @MethodSource("provideStringsForCorrectValue")
    void calculate(String input, Double expected) {
        InputView inputView = new InputView(input);
        List<Operand> operands = inputView.getOperands();
        List<Operator> operators = inputView.getOperators();
        Double result = StringCalculator.calculate(operands, operators);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideStringsForCorrectValue() {
        return Stream.of(
                Arguments.of("2 + 3 * 4 / 2", 10.0),
                Arguments.of("1 + 9 * 5 / 5", 10.0),
                Arguments.of("10 + 6 - 1 / 2", 7.5),
                Arguments.of("2 * 5 / 2 + 2", 7.0)
        );
    }
}
