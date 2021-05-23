package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRanksTest {

    private LottoRanks lottoRanks;

    @BeforeEach
    void setUp() {
        List<LottoRank> lottoRankList = Arrays.asList(LottoRank.FIFTH,
                LottoRank.LOSE,
                LottoRank.LOSE,
                LottoRank.LOSE,
                LottoRank.LOSE,
                LottoRank.LOSE,
                LottoRank.LOSE,
                LottoRank.LOSE,
                LottoRank.LOSE,
                LottoRank.LOSE,
                LottoRank.LOSE,
                LottoRank.LOSE,
                LottoRank.LOSE,
                LottoRank.LOSE);
        lottoRanks = new LottoRanks(lottoRankList);
    }

    @Test
    @DisplayName("수익률 조회")
    void totalReturnRate() {
        // given when then
        assertThat(lottoRanks.totalReturnRate()).isEqualTo(0.35);
    }

    @Test
    @DisplayName("등수 카운트 조회")
    void rankCount() {
        // given when then
        assertThat(lottoRanks.count(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(lottoRanks.count(LottoRank.FOURTH)).isEqualTo(0);
        assertThat(lottoRanks.count(LottoRank.THIRD)).isEqualTo(0);
        assertThat(lottoRanks.count(LottoRank.FIRST)).isEqualTo(0);
        assertThat(lottoRanks.count(LottoRank.LOSE)).isEqualTo(13);
    }
}