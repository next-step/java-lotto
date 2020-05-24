package calculator;

import com.sun.org.apache.xpath.internal.Arg;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputParserTest {

    private InputParser inputParser = new InputParser();

    @DisplayName("기본 구분자로 이루어진 String을 InputParser가 정상적으로 파싱")
    @ParameterizedTest
    @ValueSource(strings = {"1:2,3:4", "10,9,0,8", "1:1:1:1"})
    public void parseDefaultUserInput(String userInput) {
        String defaultDelimiter = ",|:";
        List<String> parsedNumbers = inputParser.parseInput(userInput);
        List<String> originNumbers = Arrays.asList(userInput.split(defaultDelimiter));

        assertThat(parsedNumbers).isEqualTo(originNumbers);
    }

    @DisplayName("커스텀 구분자로 이루어진 String을 InputParser가 정상적으로 파싱")
    @ParameterizedTest
    @MethodSource("mockCustomDelimiterStringBuilder")
    public void parseCustomUserInput(String userInput, String delimiter, String testString) {
        List<String> parsedNumbers = inputParser.parseInput(userInput);
        List<String> originNumbers = Arrays.asList(testString.split(delimiter));

        assertThat(parsedNumbers).isEqualTo(originNumbers);
    }

    private static Stream<Arguments> mockCustomDelimiterStringBuilder() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", ";", "1;2;3"),
                Arguments.of("//!\n1!2!49", "!", "1!2!49"),
                Arguments.of("//p\n10?19?33", "p", "10?19?33")
        );
    }
}
