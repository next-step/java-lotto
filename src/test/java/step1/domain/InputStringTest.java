package step1.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class InputStringTest {

    InputString inputString;

    @Test
    @DisplayName("input이 빈문자인 경우 테스트")
    void input_empty() {
        inputString = new InputString(" ");
        Assertions.assertEquals(inputString.getInput(), "0");
    }

    @Test
    @DisplayName("input이 null인 경우 테스트")
    void input_null() {
        inputString = new InputString(" ");
        Assertions.assertEquals(inputString.getInput(), "0");
    }

    @Test
    @DisplayName("input이 숫자 하나인 경우 테스트")
    void input_only_one_number() {
        inputString = new InputString("1");
        Assertions.assertEquals(inputString.getInput(), "1");
    }

    @ParameterizedTest
    @MethodSource("generateSplitData")
    @DisplayName("split 기능 테스트")
    void split(String input, String[] expected) {
        InputString inputString = new InputString(input);
        Assertions.assertArrayEquals(inputString.split(), expected);
    }

    static Stream<Arguments> generateSplitData() {
        return Stream.of(
                Arguments.of("//;\\n1;2;3", new String[]{"1","2","3"}),
                Arguments.of("1,2:3", new String[]{"1","2","3"}),
                Arguments.of("1,2,3", new String[]{"1","2","3"}),
                Arguments.of("1:2:3", new String[]{"1","2","3"})
        );
    }
}