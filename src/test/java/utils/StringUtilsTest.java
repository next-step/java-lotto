package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class StringUtilsTest {

    @DisplayName("1,2 를 ,로 split 했을때 잘 분리되는지 확인")
    @Test
    public void splitStringTest1() {
        String input = "1,2";

        String[] splitStrings = StringUtils.split(input);

        assertThat(splitStrings).contains("1", "2");
        assertThat(splitStrings).hasSize(2);
    }

    @DisplayName("1 를 ,로 split 했을때 1만 포함하는 배열인지 확인")
    @Test
    public void splitStringTest2() {
        String input = "1";

        String[] splitStrings = StringUtils.split(input);

        assertThat(splitStrings).containsExactly("1");
        assertThat(splitStrings).hasSize(1);
    }

    @DisplayName("(1,2) 값이 주어졌을 때 ()제거 확인")
    @Test
    public void substringTest() {
        String input = "(1,2)";

        String removedParenthesis = StringUtils.removeParenthesis(input);

        assertThat(removedParenthesis).isEqualTo("1,2");
    }

    @DisplayName("charAt을 사용하여 특정위치의 문자확인")
    @ParameterizedTest
    @CsvSource(value = {"abc:a:0", "abc:b:1", "abc:c:2"}, delimiter = ':')
    public void charAtTest(String input, String expectedChar, int index) {
        String firstChar = StringUtils.getCharAtIndex(input, index);
        assertThat(firstChar).isEqualTo(expectedChar);
    }

    @DisplayName("문자열의 길이를 벗어난 특정위치의 문자 가져올때 익셉션확인")
    @Test
    public void charAtExceptionTest() {
        String input = "abc";
        assertThatThrownBy(() ->
                StringUtils.getCharAtIndex(input, 5)
        ).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("String index out of range: 5");
    }

    @DisplayName("문자열의 길이를 벗어난 특정위치의 문자 가져올때 익셉션확인(assertThatExceptionOfType사용)")
    @Test
    public void charAtExceptionAnotherTest() {
        String input = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() ->
                        StringUtils.getCharAtIndex(input, 5)
                ).withMessageMatching("String index out of range: 5");
    }
}
