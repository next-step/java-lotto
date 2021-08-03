package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinAmountTest {
    @Test
    void valueOfMatchCount() {
        assertThat(WinAmount.valueOfMatchCount(3)).isEqualTo(WinAmount.FIFTH);
    }
}