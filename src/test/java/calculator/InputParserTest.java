package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputParserTest {

    @DisplayName("기본 구분자로 이루어진 String을 InputParser가 정상적으로 파싱")
    @ParameterizedTest
    @ValueSource(strings = {"1:2,3:4", "10,9,0,8", "1:1:1:1"})
    public void parseUserInput(String userInput) {
        InputParser inputParser = new InputParser();

        List<String> parsedNumbers = inputParser.parseInput(userInput);
        List<String> originNumbers = Arrays.asList(userInput.split(",|:"));

        assertThat(parsedNumbers).isEqualTo(originNumbers);
    }
}
