package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class YieldTest {

    @Test
    @DisplayName("수익률이 마이너스이면 IllegalArgumentException이 발생한다.")
    void minusYield() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Yield(-1.0));
    }
}