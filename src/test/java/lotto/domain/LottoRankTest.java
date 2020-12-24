package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {

    @Test
    void valueOf() {

        LottoRank lottoRank = LottoRank.valueOf(5, true);
        assertThat(lottoRank).isEqualTo(LottoRank.SECOND);

        lottoRank = LottoRank.valueOf(5, false);
        assertThat(lottoRank).isEqualTo(LottoRank.THIRD);

    }
}