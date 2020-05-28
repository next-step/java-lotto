package lotto.domain;

import lotto.domain.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoRankTest {

    @DisplayName("당첨번호의 개수가 포함된 개수에 따라 올바른 등수를 리턴한다.")
    @Test
    void getRankTest() {
        assertThat(LottoRank.getRank(6)).isEqualTo(LottoRank.RANK1);
        assertThat(LottoRank.getRank(5)).isEqualTo(LottoRank.RANK2);
        assertThat(LottoRank.getRank(4)).isEqualTo(LottoRank.RANK3);
        assertThat(LottoRank.getRank(3)).isEqualTo(LottoRank.RANK4);
        assertThat(LottoRank.getRank(2)).isEqualTo(LottoRank.BOOM);
        assertThat(LottoRank.getRank(1)).isEqualTo(LottoRank.BOOM);
        assertThat(LottoRank.getRank(0)).isEqualTo(LottoRank.BOOM);
    }

    @DisplayName("등수에 따른 금액을 올바르게 리턴한다.")
    @Test
    void getWinningAmountTest() {
        assertThat(LottoRank.RANK1.getWinningAmount()).isEqualTo(BigDecimal.valueOf(2000000000));
        assertThat(LottoRank.RANK2.getWinningAmount()).isEqualTo(BigDecimal.valueOf(1500000));
        assertThat(LottoRank.RANK3.getWinningAmount()).isEqualTo(BigDecimal.valueOf(50000));
        assertThat(LottoRank.RANK4.getWinningAmount()).isEqualTo(BigDecimal.valueOf(5000));
        assertThat(LottoRank.BOOM.getWinningAmount()).isEqualTo(BigDecimal.ZERO);
    }

    @DisplayName("당첨된 LottoRank 만 리턴한다")
    @Test
    void getWinningLottoTest() {
        LottoRank[] lottoRanks = LottoRank.getWinningLotto();

        assertThat(lottoRanks).containsOnly(LottoRank.RANK1, LottoRank.RANK2, LottoRank.RANK3, LottoRank.RANK4);
    }
}