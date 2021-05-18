package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class StringTest {

    @Test
    @DisplayName("split() 테스트")
    void split() {
        String[] numbers = "1,2".split(",");
        assertThat(numbers).containsExactly("1","2");

        String[] number = "1".split(",");
        assertThat(number).contains("1");
    }

    @Test
    @DisplayName("substring() 테스트")
    void subString() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).contains("1,2");
    }

    @Test
    @DisplayName("charAt() 예외발생 테스트")
    void getCharacter(){
        String result = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    result.charAt(4);
                }).withMessageMatching("String index out of range: \\d+");
    }
}
