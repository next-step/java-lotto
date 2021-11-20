package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class InputNumberTest {

    @Test
    @DisplayName(", :를 기준으로 문자열이 잘 구분되는지 확인한다.")
    void splitTest() {
        String input = "1,2:3";

        InputNumber inputNumber = InputNumber.create(input);
        assertThat(inputNumber).isEqualTo(new InputNumber(Arrays.asList(1, 2, 3)));
    }

    @ParameterizedTest(name = "[arguments] 값이 오면, 빈 List 를 반환한다.")
    @NullAndEmptySource
    void spiltEmptyTest(String input) {
        InputNumber inputNumber = InputNumber.create(input);
        assertThat(inputNumber).isEqualTo(new InputNumber());

    }
}
