import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StringParserTest {

    private static Stream<String> getInvalidInput() {
        return Stream.of("", null);
    }

    @Test
    void 쉼표와_콜론을_기준으로_문자열_분리() {
        String normalInput = "1:2,3";
        List<Integer> parsedInputs = StringParser.parse(normalInput);
        assertThat(parsedInputs).contains(1, 2, 3);
    }

    @Test
    void 커스텀_구분자_추가해서_문자열분리() {
        String customInput = "//;\n1,2:3;4";
        List<Integer> parsedInputs = StringParser.parse(customInput);
        assertThat(parsedInputs).contains(1, 2, 3, 4);
    }

    @ParameterizedTest
    @MethodSource("getInvalidInput")
    void 빈문자열_null_값_입력시_0반환(String invalidInput) {
        List<Integer> result = StringParser.parse(invalidInput);
        assertThat(result).containsOnly(0);
    }
}
