package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @Test
    void createNumberTest_문자열_숫자0() {
        Number number = new Number("0");
        assertThat(number.getValue()).isEqualTo(0);
    }

    @Test
    void createNumberTest_문자열_음수값() {
        assertThatThrownBy(() -> new Number("-1"))
                .hasMessageMatching("0 이하의 값을 입력했습니다.");
    }
}
