package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NumberTest {

    @DisplayName("숫자 값 객체를 생성한다.")
    @Test
    void create() {
        Number number = new Number("1");

        Number expect = new Number("1");

        assertThat(number).isEqualTo(expect);
    }
}
