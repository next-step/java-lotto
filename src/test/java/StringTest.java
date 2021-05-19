import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("String 학습 테스트")
class StringTest {

    @DisplayName("split, comma(,) argument")
    @ParameterizedTest
    @MethodSource("provideSourceToSplitWithComma")
    void splitWithComma(String target, String[] expectedResult) {
        // Given
        String testingTarget = target;

        // When
        String[] splitTarget = testingTarget.split(",");

        // Then
        assertThat(splitTarget).containsExactly(expectedResult);
    }

    @DisplayName("substring, bracket 제거")
    @Test
    void substringBracket() {
        // Given
        String testingTarget = "(1,2)";
        String expectedResult = "1,2";

        // When
        String actualResult = testingTarget.substring(1, testingTarget.length() - 1);

        // Then
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @DisplayName("charAt, 특정 인덱스 문자 읽기")
    @CsvSource({"0,a"
            , "1,b"
            , "2,c"})
    void charAtSpecificIndex(int index, char expectedResult) {
        // Given
        String givenText = "abc";

        // When
        char actualResult = givenText.charAt(index);

        // Then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("charAt, 범위 밖 인덱스 문자 읽기 예외 확인")
    void charAtOutOfGBoundsIndex() {
        // Given
        String givenText = "abc";
        int outOfBoundsIndex = Integer.MAX_VALUE;

        // When, Then
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> givenText.charAt(outOfBoundsIndex));
    }

    static Stream<Arguments> provideSourceToSplitWithComma() {
        return Stream.of(
                Arguments.of("1,2", new String[]{"1", "2"}),
                Arguments.of("1", new String[]{"1"})
        );
    }
}
