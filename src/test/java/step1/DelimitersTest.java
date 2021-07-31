package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DelimitersTest {
    @Test
    @DisplayName("커스텀 구분자가 있는지 확인")
    void hasCustomDelimiterTest() {
        assertThat(Delimiters.hasCustomDelimiter("1.1")).isFalse();

        assertThat(Delimiters.hasCustomDelimiter("//;\n1;2;3")).isTrue();
    }

    @Test
    @DisplayName("커스텀 구분자가 추출되는지 테스트")
    void getCustomDelimiterTest() {
        String delimiters = Delimiters.getCustomDelimiter("//;\n1;2;3");

        assertThat(delimiters).isEqualTo(";");
    }

    @Test
    @DisplayName("parse 테스트")
    void parseTest() {
        Delimiters delimiters1 = new Delimiters();

        assertThat(delimiters1.parse("1,1:1")).containsExactly("1", "1", "1");

        Delimiters delimiters2 = new Delimiters(";");

        assertThat(delimiters2.parse("1;2;3")).containsExactly("1", "2", "3");
    }
}
