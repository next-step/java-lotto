package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositiveNumberTest {
    @Test
    void 입력값이_음수이면_예외를_던진다() {
        assertThatThrownBy(() -> new PositiveNumber(-1))
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 입력값이_숫자_문자열일경우_parseInt메서드를_호출하면_정수형을_반환한다() {
        assertThat(new PositiveNumber(5).number()).isEqualTo(5);
    }
}
