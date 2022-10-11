package main.string_calculator.model;

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

}