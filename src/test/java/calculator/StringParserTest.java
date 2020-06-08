package calculator;

import calculator.domain.StringParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringParserTest {

    @ParameterizedTest
    @DisplayName("Empty String을 입력 받았을 경우 0을 반환 하는지 테스트")
    @NullAndEmptySource
    void ZeroIfInputEmpty(String input) {
        String[] actual = StringParser.parse(input);

        assertThat(actual).isEqualTo(new String[]{"0"});
    }

    @ParameterizedTest
    @DisplayName("숫자 문자열을 받았을 경우 해당 숫자를 가진 배열을 반환 하는 지 테스트")
    @MethodSource("provideNumberStrings")
    void StringArrayIfInputIsNumber(String input, String[] expected) {
        String[] actual = StringParser.parse(input);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideNumberStrings() {
        return Stream.of(
                Arguments.of("23", new String[]{"23"}),
                Arguments.of("1", new String[]{"1"}),
                Arguments.of("523", new String[]{"523"})
        );
    }

    @ParameterizedTest
    @DisplayName("커스텀 문자를 포함한 문자열을 받을 경우 해당 문자로 나누어진 배열을 반환 하는 지 테스트")
    @MethodSource("provideCustomNumberStrings")
    void StringArrayIfInputIsCustom(String input, String[] expected) {
        String[] actual = StringParser.parse(input);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideCustomNumberStrings() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", new String[]{"1","2","3"}),
                Arguments.of("//x\n5x23x6", new String[]{"5","23","6"}),
                Arguments.of("//&\n7&3&2", new String[]{"7","3","2"})
        );
    }

    @ParameterizedTest
    @DisplayName("정해진 문자를 포함한 문자열을 받을 경우 해당 문자로 나누어진 배열을 반환 하는 지 테스트")
    @MethodSource("provideSpecificNumberStrings")
    void StringArrayIfInputIsSpecificCharacter(String input, String[] expected) {
        String[] actual = StringParser.parse(input);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideSpecificNumberStrings() {
        return Stream.of(
                Arguments.of("1,2,3", new String[]{"1","2","3"}),
                Arguments.of("11:22:33", new String[]{"11","22","33"}),
                Arguments.of("111,222:333", new String[]{"111","222","333"})
        );
    }
}
