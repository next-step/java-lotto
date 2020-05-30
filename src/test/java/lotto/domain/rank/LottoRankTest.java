package lotto.domain.rank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    private LottoRank lottoRank;

    @Test
    void lottoRankTest_5등() {
        lottoRank = LottoRank.FIFTH;

        assertThat(lottoRank.getCountOfMatch()).isEqualTo(3);
        assertThat(lottoRank.getWinningMoney()).isEqualTo(5_000);
    }

    @Test
    void lottoRankTest_4등() {
        lottoRank = LottoRank.FOURTH;

        assertThat(lottoRank.getCountOfMatch()).isEqualTo(4);
        assertThat(lottoRank.getWinningMoney()).isEqualTo(50_000);
    }

    @Test
    void lottoRankTest_3등() {
        lottoRank = LottoRank.THIRD;

        assertThat(lottoRank.getCountOfMatch()).isEqualTo(5);
        assertThat(lottoRank.getWinningMoney()).isEqualTo(1_500_000);
    }

    @Test
    void lottoRankTest_2등() {
        lottoRank = LottoRank.SECOND;

        assertThat(lottoRank.getCountOfMatch()).isEqualTo(5);
        assertThat(lottoRank.getWinningMoney()).isEqualTo(30_000_000);
    }

    @Test
    void lottoRankTest_1등() {
        lottoRank = LottoRank.FIRST;

        assertThat(lottoRank.getCountOfMatch()).isEqualTo(6);
        assertThat(lottoRank.getWinningMoney()).isEqualTo(2_000_000_000);
    }

    @Test
    void lottoRankTest_낙첨() {
        lottoRank = LottoRank.MISS;

        assertThat(lottoRank.getCountOfMatch()).isEqualTo(0);
        assertThat(lottoRank.getWinningMoney()).isEqualTo(0);
    }


}
