import domain.Operator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import view.InputView;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@DisplayName("문자열 계산기 테스트")
public class StringArithmeticCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력값이 null이거나 빈 공백인 경우 예외를 던진다.")
    void validateInputExpressionNullAndEmpty_test(String input) {
        assertThatThrownBy(() -> InputView.validateInputExpressionAndThrow(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"%", "^", "#", "!"})
    @DisplayName("입력값이 사칙 연산이 아닌 경우 예외를 던진다.")
    void validateInputExpressionOperations_test(String input) {
        assertThatThrownBy(() -> InputView.validateInputExpressionAndThrow(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입략값에서 연산자만 분리시킬 수 있다.")
    void extractOperators_test() {
        String input = "2 + 3 * 4 / 2";
        String[] operators = {"+", "*", "/"};

        List<String> extractOperators = InputView.extractOperators(input);

        Assertions.assertThat(extractOperators).contains(operators);
    }

    @Test
    @DisplayName("입략값에서 숫자만 분리시킬 수 있다.")
    void extractNumbers_test() {
        String input = "2 + 3 * 4 / 2";
        Integer[] numbers = {2, 3, 4, 2};

        List<Integer> extractNumbers = InputView.extractNumbers(input);

        Assertions.assertThat(extractNumbers).contains(numbers);
    }

    @Test
    @DisplayName("문자열 계산기가 정상적으로 작동한다.")
    void StringArithmeticCalculator_test() {
        String input = "2 + 3 * 4 / 2";
        int expectedSumValue = 10;
        List<String> operators = InputView.extractOperators(input);
        List<Integer> numbers = InputView.extractNumbers(input);

        int sum = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            sum = Operator.calculator(operators.get(i), sum, numbers.get(i + 1));
        }

        Assertions.assertThat(sum).isEqualTo(expectedSumValue);
    }
}
