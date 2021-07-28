package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SplitterTest {

    @DisplayName("숫자 문자열을 콤마(,)로 분리한다.")
    @Test
    void splitByComma() {
        String[] numbers = Splitter.split("1,2");
        assertThat(numbers).containsExactly("1", "2");
    }

    @DisplayName("숫자 문자열을 콜론(:)으로 분리한다.")
    @Test
    void splitByColon() {
        String[] numbers = Splitter.split("3:4");
        assertThat(numbers).containsExactly("3", "4");
    }

    @DisplayName("숫자 문자열을 커스텀 구분자(//\\n)로 분리한다.")
    @Test
    void splitByCustomDelimiter() {
        String[] numbers = Splitter.split("//;\n1;2;3");
        assertThat(numbers).containsExactly("1", "2", "3");
    }

}
