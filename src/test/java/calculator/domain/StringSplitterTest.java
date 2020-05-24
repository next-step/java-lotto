package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StringSplitterTest {

    @DisplayName("기본 구분자로 이루어진 String을 Splitter가 정상적으로 분리")
    @ParameterizedTest
    @ValueSource(strings = {"1:2,3:4", "10,9,0,8", "1:1:1:1"})
    public void parseDefaultUserInput(String userInput) {
        String defaultDelimiter = ",|:";
        String[] splittedString = StringSplitter.splitString(userInput);
        String[] originString = userInput.split(defaultDelimiter);

        assertThat(splittedString).isEqualTo(originString);
    }

    @DisplayName("커스텀 구분자로 이루어진 String을 Splitter가 정상적으로 분리")
    @ParameterizedTest
    @MethodSource("mockCustomDelimiterStringBuilder")
    public void parseCustomUserInput(String userInput, String delimiter, String testString) {
        String[] splittedString = StringSplitter.splitString(userInput);
        String[] originString = testString.split(delimiter);

        assertThat(splittedString).isEqualTo(originString);
    }

    private static Stream<Arguments> mockCustomDelimiterStringBuilder() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", ";", "1;2;3"),
                Arguments.of("//!\n1!2!49", "!", "1!2!49"),
                Arguments.of("//p\n10?19?33", "p", "10?19?33")
        );
    }

    @DisplayName("UserInput이 Null이거나 Empty일 때 문자열 0을 원소로 가지는 String 배열 리턴 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    public void throwRuntimeExceptionOnInvalidArguments(String userInput) {
        String[] splittedString = StringSplitter.splitString(userInput);
        String[] expectedResult = {"0"};

        assertThat(splittedString).isEqualTo(expectedResult);
    }
}
