package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step1.Domain.Calculator;
import step1.Util.NumberUtil;
import step1.Util.StringUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    @Test
    @DisplayName("숫자들의 합")
    void sumTest() {
        Calculator calculator = new Calculator("1,2,3");
        assertThat(calculator.getSum()).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "//;\\n3;4;5",
            "//;\\n3;4:5",
            "//;\\n3:4,5",
            "3:4:5",
            "3,4,5"
    })
    @DisplayName("custom 구분자 포함 split")
    void splitTest(String input) {
        List<String> inputWords = StringUtil.splitStrings(input);
        assertThat(inputWords).containsExactly("3", "4", "5");
    }

    @Test
    @DisplayName("string list를 int형 list로 변환")
    void stringToIntTest() {
        List<String> inputWords = Arrays.asList("3", "4", "5");
        List<Integer> parsedNumber = NumberUtil.parseUnsignedInt(inputWords);
        assertThat(parsedNumber).containsExactly(3, 4, 5);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "e", "-3", ":"
    })
    @DisplayName("양수가 아니면 RuntimeException")
    void stringToIntThrowExceptionTest(String input) {
        List<String> inputWords = Collections.singletonList(input);
        assertThrows(RuntimeException.class, () -> NumberUtil.parseUnsignedInt(inputWords));
    }
}
