package lotto.vo;

import lotto.domain.LottoMachine;
import lotto.enums.LottoRank;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @Test
    public void 당첨번호와_비교한_결과를_통해_로또결과_생성() {
        // given
        long[] matchCounts = new long[LottoRank.SECOND.getMatchCount() + 1];
        matchCounts[LottoRank.FIRST.getMatchCount()] = 1;
        matchCounts[LottoRank.THIRD.getMatchCount()] = 3;

        // when
        LottoResult lottoResult = new LottoResult(matchCounts);

        // then
        assertThat(lottoResult.getNumberOfWin(LottoRank.FIRST)).isEqualTo(1);
        assertThat(lottoResult.getNumberOfWin(LottoRank.SECOND)).isEqualTo(0);
        assertThat(lottoResult.getNumberOfWin(LottoRank.THIRD)).isEqualTo(3);
        assertThat(lottoResult.getNumberOfWin(LottoRank.FOURTH)).isEqualTo(0);
    }

    @Test
    public void 당첨번호와_비교한_결과를_통해_구입한_로또_금액_계산() {
        // given
        long[] matchCounts = new long[LottoRank.SECOND.getMatchCount() + 1];
        matchCounts[LottoRank.FIRST.getMatchCount()] = 1;
        matchCounts[LottoRank.THIRD.getMatchCount()] = 3;
        matchCounts[0] = 5; // 전부 일치 하지 않는 경우

        LottoResult lottoResult = new LottoResult(matchCounts);

        // when
        long cost = lottoResult.getCost();

        // then
        assertThat(cost).isEqualTo(LottoMachine.LOTTO_PRICE * (1 + 3 + 5));
    }

    @Test
    public void 총_당첨금액_계산() {
        // given
        long[] matchCounts = new long[LottoRank.SECOND.getMatchCount() + 1];
        matchCounts[LottoRank.SECOND.getMatchCount()] = 1;
        matchCounts[LottoRank.FOURTH.getMatchCount()] = 3;

        LottoResult lottoResult = new LottoResult(matchCounts);

        // when
        long totalPrizeMoney = lottoResult.getTotalPrizeMoney();

        // then
        assertThat(totalPrizeMoney)
                .isEqualTo(LottoRank.SECOND.getPrizeMoney() + (LottoRank.FOURTH.getPrizeMoney() * 3));
    }

    @Test
    public void 총_수익률_계산() {
        // given
        long[] matchCounts = new long[LottoRank.SECOND.getMatchCount() + 1];
        matchCounts[LottoRank.SECOND.getMatchCount()] = 1;
        matchCounts[LottoRank.FOURTH.getMatchCount()] = 3;
        matchCounts[0] = 5; // 전부 일치 하지 않는 경우

        LottoResult lottoResult = new LottoResult(matchCounts);

        // when
        double totalProfitRate = lottoResult.getTotalProfitRate();

        // then
        long totalPrizeMoney = LottoRank.SECOND.getPrizeMoney() + (LottoRank.FOURTH.getPrizeMoney() * 3);
        long cost = (1 + 3 + 5) * LottoMachine.LOTTO_PRICE;

        assertThat(totalProfitRate)
                .isEqualTo((double) totalPrizeMoney / cost);
    }
}
