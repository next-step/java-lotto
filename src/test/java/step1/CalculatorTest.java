package step1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {
    @Test
    void SumTest() {
        Calculator calculator = new Calculator(Arrays.asList(1, 2, 3));
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
    void SplitTest(String input) {
        List<String> inputWords = StringUtil.splitStrings(input);
        assertThat(inputWords).containsExactly("3", "4", "5");
    }

    @Test
    void StringToIntTest() {
        List<String> inputWords = Arrays.asList("3", "4", "5");
        List<Integer> parsedNumber = NumberUtil.parsePositiveInt(inputWords);
        assertThat(parsedNumber).containsExactly(3, 4, 5);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "e", "-3", ":"
    })
    void StringToIntThrowExceptionTest(String input) {
        List<String> inputWords = Collections.singletonList(input);
        assertThatThrownBy(() -> NumberUtil.parsePositiveInt(inputWords)).isInstanceOf(RuntimeException.class);
    }
}
