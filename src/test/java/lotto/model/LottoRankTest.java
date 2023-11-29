package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoRankTest {

    @Test
    void rank() {
        assertThat(LottoRank.valueOf(5, true)).isEqualTo(LottoRank.SECOND);
    }
}