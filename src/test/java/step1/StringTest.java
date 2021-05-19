package step1;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {

    @DisplayName("',' 기준으로 문자열 split 검증")
    @MethodSource("splitTestCase")
    @ParameterizedTest
    void splitTest(String data, String[] expected) {
        String[] actual = data.split(",");
        assertThat(actual).containsExactly(expected);
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> splitTestCase() {
        return Stream.of(
            Arguments.of("1", new String[] {"1"}),
            Arguments.of("1,2", new String[] {"1", "2"}),
            Arguments.of("1,2,3", new String[] {"1", "2", "3"})
        );
    }

    @DisplayName("substring으로 (, ) 제거 검증")
    @MethodSource("substringTestCase")
    @ParameterizedTest
    void substringTest(String data, String expected) {
        String actual = data.substring(1, data.length() - 1);
        assertEquals(expected, actual);
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> substringTestCase() {
        return Stream.of(
            Arguments.of("(1)", "1"),
            Arguments.of("(1,2)", "1,2"),
            Arguments.of("(1,2,3)", "1,2,3")
        );
    }

    @DisplayName("charAt으로 N번째 char 추출 검증")
    @MethodSource("chatAtTest01Case")
    @ParameterizedTest
    void chatAtTest01(String data, int index, char expected) {
        char actual = data.charAt(index);
        assertEquals(expected, actual);
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> chatAtTest01Case() {
        return Stream.of(
            Arguments.of("(1)", 1, "1"),
            Arguments.of("(1,2)", 4, ")"),
            Arguments.of("(1,2,3)", 5, "3")
        );
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @DisplayName("charAt 매개변수가 원본 데이터 index를 벗어나는 경우 예외 발생")
    @MethodSource("chatAtTest02Case")
    @ParameterizedTest
    void chatAtTest02(String data, int index) {
        assertThrows(IndexOutOfBoundsException.class, () -> data.charAt(index));
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> chatAtTest02Case() {
        return Stream.of(
            Arguments.of("(1)", -1),
            Arguments.of("(1,2)", 7),
            Arguments.of("(1,2,3)", 20)
        );
    }
}
