package calculator.model;

import calculator.exception.NotEssenceException;
import calculator.exception.ValidateInputException;
import calculator.exception.ValidateNumberException;
import calculator.exception.ValidateOperatorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    private final StringCalculator stringCalculator = new StringCalculator();


    @DisplayName("인풋 값 테스트 : null or empty")
    @ParameterizedTest
    @NullAndEmptySource
    void input_test_null_empty(String input) {
        // expected
        assertThatExceptionOfType(ValidateInputException.class)
                .isThrownBy(() -> stringCalculator.makeInputList(input));
    }

    @Test
    @DisplayName("인풋 값 테스트")
    void input_test() {

        // given
        String input = "1 + 2 - 1 * 2 / 1";

        // when
        List<String> inputList = stringCalculator.makeInputList(input);

        // then
        assertThat(inputList).isEqualTo(List.of("1", "+", "2", "-", "1", "*", "2", "/", "1"));
    }

    @Test
    @DisplayName("덧셈 구현")
    void add_test() {
        // given
        Integer firstNumber = 1;
        Integer secondNumber = 2;

        // when
        Integer addResult = Operator.calculate("+", firstNumber, secondNumber);

        // then
        assertThat(addResult).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈 구현")
    void sub_test() {
        // given
        Integer firstNumber = 1;
        Integer secondNumber = 2;

        // when
        Integer addResult = Operator.calculate("-", firstNumber, secondNumber);

        // then
        assertThat(addResult).isEqualTo(-1);
    }

    @Test
    @DisplayName("곱셈 구현")
    void multiply_test() {
        // given
        Integer firstNumber = 1;
        Integer secondNumber = 2;

        // when
        Integer addResult = Operator.calculate("*", firstNumber, secondNumber);

        // then
        assertThat(addResult).isEqualTo(2);
    }

    @Test
    @DisplayName("나눗셈 구현_실패")
    void divide_test_fail() {
        // given
        Integer firstNumber = 1;
        Integer secondNumber = 2;

        // expected
        assertThatExceptionOfType(NotEssenceException.class)
                .isThrownBy(() -> Operator.calculate("/", firstNumber, secondNumber));
    }

    @Test
    @DisplayName("나눗셈 구현_성공")
    void divide_test_success() {
        // given
        Integer firstNumber = 2;
        Integer secondNumber = 2;

        // when
        Integer result = Operator.calculate("/", firstNumber, secondNumber);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("계산 홀수번째 입력 값 숫자 아님")
    void calculate_input_number_fail() {
        // given
        String input = "/ + 2 - 1 * 2 / 1";

        // expected
        assertThatExceptionOfType(ValidateNumberException.class)
                .isThrownBy(() -> stringCalculator.calculate(input));
    }

    @Test
    @DisplayName("계산 짝수번째 입력 값 연산자 아님")
    void calculate_input_operator_fail() {
        // given
        String input = "1 1 2 - 1 * 2 / 1";

        // expected
        assertThatExceptionOfType(ValidateOperatorException.class)
                .isThrownBy(() -> stringCalculator.calculate(input));
    }

    @Test
    @DisplayName("계산 덧셈")
    void calculate_add() {
        // given
        String input = "1 + 2";

        // when
        Integer calculate = stringCalculator.calculate(input);

        // then
        assertThat(calculate).isEqualTo(3);
    }

    @Test
    @DisplayName("계산 뺄셈")
    void calculate_sub() {
        // given
        String input = "1 - 2";

        // when
        Integer calculate = stringCalculator.calculate(input);

        // then
        assertThat(calculate).isEqualTo(-1);
    }

    @Test
    @DisplayName("계산 곱셈")
    void calculate_multiply() {
        // given
        String input = "1 * 2";

        // when
        Integer calculate = stringCalculator.calculate(input);

        // then
        assertThat(calculate).isEqualTo(2);
    }

    @Test
    @DisplayName("계산 나눗셈")
    void calculate_divide() {
        // given
        String input = "2 / 2";

        // when
        Integer calculate = stringCalculator.calculate(input);

        // then
        assertThat(calculate).isEqualTo(1);
    }

    @Test
    @DisplayName("계산 성공")
    void calculate() {
        // given
        String input = "2 + 3 * 4 / 2";

        // when
        Integer calculate = stringCalculator.calculate(input);

        // then
        assertThat(calculate).isEqualTo(10);
    }

}
