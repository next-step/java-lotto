package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @Test
    void 생성자_테스트() {
        Number number = new Number(1);

        assertThat(number).isEqualTo(new Number(1));
    }

    @Test
    void 생성자_예외() {
        assertThatThrownBy(() -> {
            Number number = new Number(-1);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            Number number = new Number(46);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
