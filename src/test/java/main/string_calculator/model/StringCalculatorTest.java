package main.string_calculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    @DisplayName("인풋 값 테스트")
    void input_test() {

        // given
        StringCalculator stringCalculator = new StringCalculator();
        String input = "1 + 2 - 1 * 2 / 1";

        // when
        List<String> inputList = stringCalculator.makeInputList(input);

        // then
        assertThat(inputList).isEqualTo(List.of("1", "+", "2", "-", "1", "*", "2", "/", "1"));
    }

}