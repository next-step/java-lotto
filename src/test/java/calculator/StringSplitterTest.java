package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringSplitterTest {

    @ParameterizedTest(name = "[{argumentsWithNames}] StringSplitter이 잘 동작하는지 확인한다.")
    @ValueSource(strings = "1,2:3")
    void splitTest(String input) {
        assertThat(new StringSplitter().split(input)).isEqualTo(new String[]{"1", "2", "3"});
    }

    @ParameterizedTest(name = "[{argumentsWithNames}] StringSplitter이 잘 동작하는지 확인한다.")
    @ValueSource(strings = "//;\n1;2;3")
    void splitWithCustomRegexTest(String input) {
        assertThat(new StringSplitter().split(input)).isEqualTo(new String[]{"1", "2", "3"});
    }

}