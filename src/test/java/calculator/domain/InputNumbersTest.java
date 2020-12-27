package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputNumbersTest {

    @Test
    @DisplayName("영어가 들어왔을때 Exception 처리")
    void split_input_string() throws Exception {
        //Given
        String[] input = {"A", "B", "C"};
        Assertions.assertThatThrownBy(() -> {
            InputNumbers inputNumbers = new InputNumbers(input);
        }).isInstanceOf(RuntimeException.class);
    }
}
