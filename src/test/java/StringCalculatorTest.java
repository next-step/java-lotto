import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class StringCalculatorTest {

    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 숫자로 변환한다.")
    @MethodSource("provideSplitSource")
    @ParameterizedTest
    void split(String input, String... expected) {
        String[] actual = input.split(",|:");
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideSplitSource() {
        return Stream.of(
            Arguments.of("1,2", new String[]{"1", "2"}),
            Arguments.of("1,2:3,4:5", new String[]{"1", "2", "3", "4", "5"}),
            Arguments.of("1:2222", new String[]{"1", "2222"}),
            Arguments.of("332,22:1", new String[]{"332", "22", "1"})
        );
    }

    @DisplayName("덧셈을 한다.")
    @MethodSource("providePlus")
    @ParameterizedTest
    void construct(String input, int expected) {
        StringCalculator calculator = new StringCalculator(input);
        int actual = calculator.run();

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> providePlus() {
        return Stream.of(
            Arguments.of("1,2", 3),
            Arguments.of("2,3:2", 7),
            Arguments.of("4:3:8,8,0", 23),
            Arguments.of("9,4,9,1", 23)
        );
    }

    @DisplayName("커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.")
    @MethodSource("provideCustomSplitSource")
    @ParameterizedTest
    void custom(String input, String... expected) {
        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = pattern.matcher(input);
        matcher.find();

        String delimiter = matcher.group(1);
        String values = matcher.group(2);

        String[] actual = values.split(delimiter);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideCustomSplitSource() {
        return Stream.of(
            Arguments.of("//;\n1;2;3", new String[]{"1", "2", "3"}),
            Arguments.of("//,\n1,2,3,4,5", new String[]{"1", "2", "3", "4", "5"}),
            Arguments.of("//@\n1@2222", new String[]{"1", "2222"}),
            Arguments.of("//!\n332!22!1", new String[]{"332", "22", "1"})
        );
    }

    @DisplayName("커스텀 덧셈을 한다.")
    @MethodSource("provideCustomPlus")
    @ParameterizedTest
    void constructCustom(String input, int expected) {
        StringCalculator calculator = new StringCalculator(input);
        int actual = calculator.run();

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideCustomPlus() {
        return Stream.of(
            Arguments.of("//;\n1;2;3", 6),
            Arguments.of("//,\n1,2,3,4,5", 15),
            Arguments.of("//@\n1@2222", 2223),
            Arguments.of("//!\n332!22!1", 355)
        );
    }

    @DisplayName("문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.")
    @MethodSource("provideException")
    @ParameterizedTest
    void exception(String input) {
        assertThatThrownBy(() ->
            new StringCalculator(input)
        ).isInstanceOf(RuntimeException.class)
            .hasMessage("문자열 계산기에 숫자 이외의 값 또는 음수를 전달해서는 안됩니다.");
    }

    private static Stream<Arguments> provideException() {
        return Stream.of(
            Arguments.of("1,-2"),
            Arguments.of("1,2a:3,4:5"),
            Arguments.of("1:2222b"),
            Arguments.of("//!\n332#$!22!1")
        );
    }
}
