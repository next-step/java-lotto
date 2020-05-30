package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @DisplayName("당첨번호의 개수가 포함된 개수에 따라 올바른 등수를 리턴한다.")
    @Test
    void getRankTest() {
        assertThat(LottoRank.getRank(6, false)).isEqualTo(LottoRank.RANK1);
        assertThat(LottoRank.getRank(5, true)).isEqualTo(LottoRank.RANK2);
        assertThat(LottoRank.getRank(5, false)).isEqualTo(LottoRank.RANK3);
        assertThat(LottoRank.getRank(4, false)).isEqualTo(LottoRank.RANK4);
        assertThat(LottoRank.getRank(3, false)).isEqualTo(LottoRank.RANK5);
        assertThat(LottoRank.getRank(2, false)).isEqualTo(LottoRank.BOOM);
        assertThat(LottoRank.getRank(1, false)).isEqualTo(LottoRank.BOOM);
        assertThat(LottoRank.getRank(0, true)).isEqualTo(LottoRank.BOOM);
        assertThat(LottoRank.getRank(0, false)).isEqualTo(LottoRank.BOOM);
        assertThat(LottoRank.getRank(2, true)).isEqualTo(LottoRank.BOOM);
    }

    @DisplayName("등수에 따른 금액을 올바르게 리턴한다.")
    @Test
    void getWinningAmountTest() {
        assertThat(LottoRank.RANK1.getWinningAmount()).isEqualTo(BigDecimal.valueOf(2000000000));
        assertThat(LottoRank.RANK2.getWinningAmount()).isEqualTo(BigDecimal.valueOf(30000000));
        assertThat(LottoRank.RANK3.getWinningAmount()).isEqualTo(BigDecimal.valueOf(1500000));
        assertThat(LottoRank.RANK4.getWinningAmount()).isEqualTo(BigDecimal.valueOf(50000));
        assertThat(LottoRank.RANK5.getWinningAmount()).isEqualTo(BigDecimal.valueOf(5000));
        assertThat(LottoRank.BOOM.getWinningAmount()).isEqualTo(BigDecimal.ZERO);
    }

    @DisplayName("당첨된 LottoRank 만 리턴한다")
    @Test
    void getWinningLottoTest() {
        List<LottoRank> lottoRanks = LottoRank.getWinningLotto();

        assertThat(lottoRanks).containsOnly(LottoRank.RANK1, LottoRank.RANK2, LottoRank.RANK3, LottoRank.RANK4, LottoRank.RANK5);
    }
}