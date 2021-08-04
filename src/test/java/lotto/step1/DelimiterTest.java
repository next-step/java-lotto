package lotto.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DelimiterTest {

    @Test
    @DisplayName("입력 값에 커스텀 구분자가 있는지 확인1")
    void checkCustomDelimiter1() {
        Delimiter delimiter = new Delimiter("//,\n1,2,3");
        assertThat(delimiter.isCustomDelimiter()).isTrue();
    }

    @Test
    @DisplayName("입력 값에 커스텀 구분자가 있는지 확인2")
    void checkCustomDelimiter2() {
        Delimiter delimiter = new Delimiter("1,2,3");
        assertThat(delimiter.isCustomDelimiter()).isFalse();
    }

    @Test
    @DisplayName("커스텀 구분자 문자열 가져오기")
    void getCustomDelimiter() {
        Delimiter delimiter = new Delimiter("//;\n1;2;3");
        assertThat(delimiter.getCustomDelimiter()).isEqualTo(";");
    }

    @Test
    @DisplayName("커스텀 구분자 문자열 가져오기2")
    void getCustomDelimiter2() {
        Delimiter delimiter = new Delimiter("1;2;3");
        assertThat(delimiter.getCustomDelimiter()).isEqualTo("");
    }

    @Test
    @DisplayName("문자열 배열 가져오기")
    void getNumbers() {
        Delimiter delimiter = new Delimiter("1,2,3");
        assertThat(delimiter.getNumbers()).containsExactly("1","2","3");
    }

    @Test
    @DisplayName("문자열 배열 가져오기2")
    void getNumbers2() {
        Delimiter delimiter = new Delimiter("1:2:3");
        assertThat(delimiter.getNumbers()).containsExactly("1","2","3");
    }

    @Test
    @DisplayName("문자열 배열 가져오기3")
    void getNumbers3() {
        Delimiter delimiter = new Delimiter("//;\n1;2;3");
        assertThat(delimiter.getNumbers()).containsExactly("1","2","3");
    }

}