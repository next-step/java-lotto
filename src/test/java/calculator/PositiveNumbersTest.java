package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TokensTest {
    @Test
    void 토큰들중에서_음수를_포함하고_있으면_예외를_던진다() {
        assertThat(1).isEqualTo(1);
        assertThatThrownBy(() -> new Tokens(new String[]{"1", "2", "-1"}))
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 토큰들을_입력으로_받으면_합을_반환한다() {
        assertThat(new Tokens(new String[] {"1", "3", "5"}).sum()).isEqualTo(9);
    }
}
