package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    private static final String SPLIT_SYMBOL = ",";

    @Test
    @DisplayName("문자 split")
    public void split() {
        String string1 = "1,2";
        String string2 = "1";

        String[] splitString1 = string1.split(SPLIT_SYMBOL);
        String[] splitString2 = string2.split(SPLIT_SYMBOL);

        assertThat(splitString1).contains("1");
        assertThat(splitString1).contains("2");
        assertThat(splitString1).containsExactly("1", "2");

        assertThat(splitString2).contains("1");
        assertThat(splitString2).containsExactly("1");
    }

    @Test
    @DisplayName(" substring 활용하여 () 제거 및 '1,2' 반환")
    public void substring() {
        String testString = "(1,2)";

        String subString = testString.substring(1, testString.length() - 1);

        assertThat(subString).isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    @DisplayName("charAt 활용하여 특정 위치 문자를 가져오기")
    public void charAt(int position, char charAtChar) {
        String testString = "abc";
        assertThat(testString.charAt(position)).isEqualTo(charAtChar);
    }

    @Test
    @DisplayName("charAt 범위를 벗어나는 경우 StringIndexOutOfBoundsException 발생")
    public void charAtException() {
        String testString = "abc";

        assertThatThrownBy(() -> testString.charAt(3))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");

        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> testString.charAt(3))
                .withMessage("String index out of range: %s", "3")
                .withMessageMatching("String index out of range: 3")
                .withMessageContaining("String index out of range")
        ;
    }
}
