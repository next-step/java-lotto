package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

class NumberTest {
    @Test
    void 번호_생성() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Number(0));
        assertThatIllegalArgumentException().isThrownBy(() -> new Number(46));
    }
}