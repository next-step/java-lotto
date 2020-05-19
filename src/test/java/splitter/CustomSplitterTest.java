package splitter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class CustomSplitterTest {

    private CustomSplitter customSplitter;

    @BeforeEach
    void setUp() {
        customSplitter = new CustomSplitter();
    }

    @DisplayName("문자열이 정규표현식 패턴에 매칭되면 true 반환")
    @ParameterizedTest
    @MethodSource("customDelimiterCase")
    void support(final String customDelimiter, final boolean expected) {
        assertThat(customSplitter.support(customDelimiter)).isSameAs(expected);
    }

    private static Stream<Arguments> customDelimiterCase() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", true),
                Arguments.of("//\\^\n10000", true),
                Arguments.of("//\\|\n1|4", true),
                Arguments.of("//|\n10000", true),
                Arguments.of("//*\n10*20", true),
                Arguments.of("//\\*\n10000", true),
                Arguments.of("//++\n10++20", true),
                Arguments.of("//?\n", true),
                Arguments.of("4,6", false),
                Arguments.of("", false)
        );
    }

    @DisplayName("빈 문자열을 입력하면 빈 String 배열을 반환")
    @ParameterizedTest
    @EmptySource
    void failureSplitByEmpty(final String value) {
        assertThat(customSplitter.split(value))
                .isEqualTo(new String[0]);
    }

    @DisplayName("null 을 입력하면 NullPointerException 예외 발생")
    @ParameterizedTest
    @NullSource
    void failureSplitByNull(final String value) {
        assertThatNullPointerException().isThrownBy(() -> customSplitter.split(value));
    }

    @DisplayName("매칭되지 않는 정규 표현식 문자열이 들어오면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = { "3,4", "//1", "\n1" })
    void failureSplit(final String value) {
        assertThatThrownBy(() -> customSplitter.split(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("커스텀 구분자에 따라 입력값들 중 숫자를 분리한 String 배열을 반환")
    @ParameterizedTest
    @MethodSource("splitSuccessCase")
    void successSplit(final String input, final String[] expected) {
        assertThat(customSplitter.split(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> splitSuccessCase() {
        return Stream.of(
                Arguments.of("//;\n0", new String[]{"0"}),
                Arguments.of("//;\n10000", new String[]{"10000"}),
                Arguments.of("//;\n1;2;3", new String[]{"1", "2", "3"}),
                Arguments.of("//|\n999", new String[]{"999"}),
                Arguments.of("//|\n0|1|2", new String[]{"0", "1", "2"}),
                Arguments.of("//\\|\n0|1|2", new String[]{"0", "1", "2"}),
                Arguments.of("//.\n1", new String[]{"1"}),
                Arguments.of("//.\n10011.2.3", new String[]{"10011", "2", "3"}),
                Arguments.of("//^\n200^22", new String[]{"200", "22"}),
                Arguments.of("//*\n1*2*3*", new String[]{"1", "2", "3"}),
                Arguments.of("//\\*\n1*2*3*", new String[]{"1", "2", "3"})
        );
    }
}
