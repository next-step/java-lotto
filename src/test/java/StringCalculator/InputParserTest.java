package StringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class InputParserTest {

    @DisplayName("콜론,쉼표 기준 인풋 파싱 테스트")
    @ParameterizedTest
    @CsvSource(value = {"!0", "''!0", "1,2!1,2", "1,2,3!1,2,3", "1,2:3!1,2,3"}, delimiter = '!')
    void testInputParsingWithColonOrComma(String input, String parsed) {
        List<Integer> actual = InputParser.parseStringListToIntegerList(input);
        List<Integer> expected = Arrays.stream(parsed.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("커스텀 구분자 기준 인풋 파싱 테스트")
    @Test
    void testInputParsingWithCustomizedDelimiter() {
        assertThat(InputParser.parseStringListToIntegerList("//;\n1;2;3")).isEqualTo(Arrays.asList(1, 2, 3));
    }
}
