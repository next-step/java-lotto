package StringAddCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSplitterTest {

    @Test
    @DisplayName("(,) 로 숫자를 나눈다")
    public void splitComma() {
         String[] numbers = StringSplitter.split("1,2,3");
         assertThat(numbers).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("(:) 으로 숫자를 나눈다")
    public void splitColon() {
        String[] numbers = StringSplitter.split("4:5:6:7");
        assertThat(numbers).containsExactly("4", "5", "6", "7");
    }

    @Test
    @DisplayName("커스텀 구분자로 숫자를 나눈다")
    public void splitCustom() {
        String[] numbers = StringSplitter.split("//=\n8=9=10");
        assertThat(numbers).containsExactly("8", "9", "10");
    }
}
