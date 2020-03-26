package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberTest {

    @DisplayName("숫자 값 객체를 생성한다.")
    @Test
    void create() {
        Number number = Number.valueOf("1");

        Number expect = Number.valueOf("1");

        assertThat(number).isEqualTo(expect);
    }
}
