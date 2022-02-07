package stringadder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import stringadder.utils.StringUtils;

public class AdderTest {

    public static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(Arrays.asList("2", "3"), 5),
            Arguments.of(Arrays.asList("3", "5"), 8)
        );
    }

    @DisplayName("쉼표_콜론_기준으로_문자열구분")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3", "//;\n1;2;3", "//-\n1-2-3"})
    void stringSplitTest(String input) {
        List<String> parsingInput = StringUtils.splitInput(input);
        assertAll(
            () -> assertThat(parsingInput.get(0)).isEqualTo("1"),
            () -> assertThat(parsingInput.get(1)).isEqualTo("2"),
            () -> assertThat(parsingInput.get(2)).isEqualTo("3")
        );
    }

    @DisplayName("커스텀_구분자가_존재하지_않는_경우")
    @ParameterizedTest
    @ValueSource(strings = {"//\n"})
    void splitCustomDelimiterTest(String input) {
        assertThatIllegalArgumentException()
            .isThrownBy(()->StringUtils.splitInput(input));
    }

    @DisplayName("더하기_테스트")
    @ParameterizedTest
    @MethodSource("provideArguments")
    void sumTest(List<String> input, int expected) {
        int result = Adder.add(input);
        System.out.println(result);
        assertThat(result).isEqualTo(expected);
    }
}
