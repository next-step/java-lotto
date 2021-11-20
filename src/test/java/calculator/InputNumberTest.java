package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputNumberTest {

    @Test
    @DisplayName(", :를 기준으로 문자열이 잘 구분되는지 확인한다.")
    void splitTest() {
        String input = "1,2:3";

        InputNumber inputNumber = InputNumber.create(input);
        assertThat(inputNumber).isEqualTo(new InputNumber(Arrays.asList(1, 2, 3)));
    }


}
