package splitter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class CommaAndColonSplitterTest {

    private CommaAndColonSplitter commaAndColonSplitter;

    @BeforeEach
    void setUp() {
        commaAndColonSplitter = new CommaAndColonSplitter();
    }

    @DisplayName("기본으로 문자열 계산기에 지원되는 구분자이므로 항상 지원 가능한 true 값 반환")
    @ParameterizedTest
    @NullAndEmptySource
    @MethodSource("anyValueCase")
    void support(final String customDelimiter) {
        assertThat(commaAndColonSplitter.support(customDelimiter)).isTrue();
    }

    private static Stream<Arguments> anyValueCase() {
        return Stream.of(
                Arguments.of("//;\n1;2;3"),
                Arguments.of("//?\n"),
                Arguments.of("4,6")
        );
    }

    @DisplayName("빈 문자열을 입력하면 빈 String 배열을 반환")
    @ParameterizedTest
    @EmptySource
    void failureSplitByEmpty(final String value) {
        assertThat(commaAndColonSplitter.split(value))
                .isEqualTo(new String[0]);
    }

    @DisplayName("null 을 입력하면 NullPointerException 예외 발생")
    @ParameterizedTest
    @NullSource
    void failureSplitByNull(final String value) {
        assertThatNullPointerException().isThrownBy(() -> commaAndColonSplitter.split(value));
    }

    @DisplayName("콜론(:) 또는 콤마(,)를 구분자로 분리한 String 배열을 반환")
    @ParameterizedTest
    @MethodSource("splitSuccessCase")
    void successSplit(final String value, final String[] expected) {
        assertThat(commaAndColonSplitter.split(value)).isEqualTo(expected);
    }

    private static Stream<Arguments> splitSuccessCase() {
        return Stream.of(
                Arguments.of("3*4", new String[]{"3*4"}),
                Arguments.of("//1", new String[]{"//1"}),
                Arguments.of("\n1", new String[]{"\n1"}),
                Arguments.of("0", new String[]{"0"}),
                Arguments.of("10011,2,3", new String[]{"10011", "2", "3"}),
                Arguments.of("200:22", new String[]{"200", "22"}),
                Arguments.of("1,2:3", new String[]{"1", "2", "3"})
        );
    }
}
