package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumbersTest {
    @Test
    @DisplayName("string으로 받은 값을 Integer로 파싱한다.")
    void stringToInteger() {
        String string = "2";

        assertThat(Numbers.stringToInteger(string)).isEqualTo(2);
    }

    @Test
    @DisplayName("파싱할 문자열 내용이 숫자가 아닌 경우 Exception 처리한다.")
    void stringToIntegerException() {
        String string = "test";

        assertThatThrownBy(() -> Numbers.stringToInteger(string))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
