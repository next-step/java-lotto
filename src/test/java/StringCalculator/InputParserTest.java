package StringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

public class InputParserTest {

    @DisplayName("인풋 파싱 테스트")
    @ParameterizedTest
    @CsvSource(value = {"!0", "''!0", "1,2!1,2", "1,2,3!1,2,3", "1,2:3!1,2,3"}, delimiter = '!')
    void inputParseingTest(String input, String parsed) {
        assertThat(InputParser.parseStringToStringList(input)).isEqualTo(Arrays.asList(parsed.split(",")));
    }
}
