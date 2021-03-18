package stringaddcalculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @Test
    void numberTest_생성() {
        Number number = new Number("1");
        assertThat(number.value()).isEqualTo(1);
    }

    @Test
    void numberTest_생성_실패_문자() {
        assertThatThrownBy(() -> new Number("s")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void numberTest_생성_음수() {
        assertThatThrownBy(() -> new Number("-1")).isInstanceOf(RuntimeException.class);
    }
}
