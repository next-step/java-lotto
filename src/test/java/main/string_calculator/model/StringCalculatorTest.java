package main.string_calculator.model;

import main.string_calculator.exception.NotEssence;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private final StringCalculator stringCalculator = new StringCalculator();

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
        Integer addResult = stringCalculator.add(firstNumber, secondNumber);

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
        Integer addResult = stringCalculator.sub(firstNumber, secondNumber);

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
        Integer addResult = stringCalculator.multiply(firstNumber, secondNumber);

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
        assertThatExceptionOfType(NotEssence.class)
                .isThrownBy(() -> stringCalculator.divide(firstNumber, secondNumber));
    }

    @Test
    @DisplayName("나눗셈 구현_성공")
    void divide_test_success() {
        // given
        Integer firstNumber = 2;
        Integer secondNumber = 2;

        // when
        Integer result = stringCalculator.divide(firstNumber, secondNumber);

        // then
        assertThat(result).isEqualTo(1);
    }

}