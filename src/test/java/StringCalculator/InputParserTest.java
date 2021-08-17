package StringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

public class InputParserTest {

    @DisplayName("콜론,쉼표 기준 인풋 파싱 테스트")
    @ParameterizedTest
    @CsvSource(value = {"!0", "''!0", "1,2!1,2", "1,2,3!1,2,3", "1,2:3!1,2,3"}, delimiter = '!')
    void testInputParsingWithColonOrComma(String input, String parsed) {
        assertThat(InputParser.parseStringToStringList(input)).isEqualTo(Arrays.asList(parsed.split(",")));
    }

    @DisplayName("커스텀 구분자 기준 인풋 파싱 테스트")
    @Test
    void testInputParsingWithCustomizedDelimiter() {
        assertThat(InputParser.parseStringToStringList("//;\n1;2;3")).isEqualTo(Arrays.asList("1,2,3".split(",")));
    }
}
