package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class InputTest {

    Input input;

    @ParameterizedTest(name = "기본 구분자. inputValue={0}, expected={1}")
    @MethodSource
    void splitWithDefaultDelimiter(String inputValue, List<String> expected) {

        input = new Input(inputValue);
        assertThat(input.split()).isEqualTo(expected);
    }

    @ParameterizedTest(name = "커스텀 구분자. inputValue={0}, expected={1}")
    @MethodSource
    void splitWithCustomDelimiter(String inputValue, List<String> expected) {

        input = new Input(inputValue);
        assertThat(input.split()).isEqualTo(expected);
    }

    private static Stream<Arguments> splitWithDefaultDelimiter() {

        return Stream.of(
                Arguments.of("1,2,3", Arrays.asList("1", "2", "3")),
                Arguments.of("1:2,3", Arrays.asList("1", "2", "3"))
        );
    }

    private static Stream<Arguments> splitWithCustomDelimiter() {

        return Stream.of(
                Arguments.of("//;\\n1;2;3", Arrays.asList("1", "2", "3")),
                Arguments.of("//!!\\n1!!2!!3", Arrays.asList("1", "2", "3")),
                Arguments.of("//abc\\n1abc2abc3", Arrays.asList("1", "2", "3"))
        );
    }
}