package step1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "//;\\n3;4;5",
            "//;\\n3;4:5",
            "//;\\n3:4,5",
            "3:4:5",
            "3,4,5"
    })
    void splitTest(String input) {
        List<String> inputWords = StringUtil.splitStrings(input);
        assertThat(inputWords).containsExactly("3", "4", "5");
    }

    @Test
    void StringToIntTest() {
        List<String> inputWords = Arrays.asList("3", "4", "5");
        List<Integer> parsedNumber = StringUtil.parsePositiveInt(inputWords);
        assertThat(parsedNumber).containsExactly(3, 4, 5);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "e", "-3", ":"
    })
    void StringToIntThrowExceptionTest(String input) {
        List<String> inputWords = Arrays.asList(input);
        assertThatThrownBy(() -> StringUtil.parsePositiveInt(inputWords)).isInstanceOf(RuntimeException.class);
    }
}
