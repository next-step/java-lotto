package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoCountTest {
    @Test
    void valid() {
        assertThatThrownBy(() -> new LottoCount(-1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoCount(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
