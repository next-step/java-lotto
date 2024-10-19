package lotto.domain;

import org.junit.jupiter.api.Test;

import static lotto.domain.LottoRank.*;
import static org.assertj.core.api.Assertions.assertThat;


class LottoRankTest {

    @Test
    void _1등_반환() {
        assertThat(valueOf(6, false)).isEqualTo(FIRST);
    }

    @Test
    void _2등_반환() {
        assertThat(valueOf(5, true)).isEqualTo(SECOND);
    }

    @Test
    void _3등_반환() {
        assertThat(valueOf(5, false)).isEqualTo(THIRD);
    }
}
