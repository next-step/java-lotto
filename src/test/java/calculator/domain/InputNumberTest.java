package calculator.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputNumberTest {
    @Test
    @DisplayName("입력 값을 구분자를 기준으로 분리하는 기능")
    void split_input_string() throws Exception {
        //Given
        String input = "1, 2: 3";
        InputNumber inputNumber = new InputNumber(input);


        //When
        List<Integer> split = inputNumber.split();

        //Then
        Assertions.assertThat(split).contains(1);
        Assertions.assertThat(split).contains(2);
        Assertions.assertThat(split).contains(3);
    }
}
