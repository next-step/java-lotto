package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TokenTest {
    @Test
    void 토큰이_음수이면_예외를_던진다() {
        assertThatThrownBy(() -> new Token("-1"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 토큰이_숫자_문자열일경우_parseInt메서드를_호출하면_정수형을_반환한다() {
        assertThat(new Token("5").parseInt()).isEqualTo(5);
    }
}
