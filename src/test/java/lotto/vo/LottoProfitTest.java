package lotto.vo;

import lotto.domain.LottoMachine;
import lotto.enums.LottoRank;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoProfitTest {
    @Test
    public void 당첨_결과로_원금_계산() {
        // given
        List<LottoRank> lottoRanks =
                Arrays.asList(LottoRank.FIRST, LottoRank.THIRD, LottoRank.FAIL, LottoRank.FAIL);
        LottoWinResult lottoWinResult = new LottoWinResult(lottoRanks);

        // when
        LottoProfit lottoProfit = new LottoProfit(lottoWinResult);
        long cost = lottoProfit.getCost();

        // then
        assertThat(cost).isEqualTo(LottoMachine.LOTTO_PRICE.getAmount() * lottoRanks.size());
    }

    @Test
    public void 당첨_결과로_총_당첨_금액_계산() {
        // given
        List<LottoRank> lottoRanks =
                Arrays.asList(LottoRank.FIRST, LottoRank.THIRD, LottoRank.FAIL, LottoRank.FAIL);
        LottoWinResult lottoWinResult = new LottoWinResult(lottoRanks);

        // when
        LottoProfit lottoProfit = new LottoProfit(lottoWinResult);
        long totalPrizeMoney = lottoProfit.getTotalPrizeMoney();

        // then
        assertThat(totalPrizeMoney)
                .isEqualTo(lottoRanks.stream().mapToLong(LottoRank::getPrizeMoney).sum());
    }

    @Test
    public void 당첨_결과로_총_이익률_계산() {
        // given
        List<LottoRank> lottoRanks =
                Arrays.asList(LottoRank.FIRST, LottoRank.THIRD, LottoRank.FAIL, LottoRank.FAIL);
        LottoWinResult lottoWinResult = new LottoWinResult(lottoRanks);

        // when
        LottoProfit lottoProfit = new LottoProfit(lottoWinResult);
        double totalProfitRate = lottoProfit.getTotalProfitRate();

        // then
        long realTotalPrizeMoney = lottoRanks.stream().mapToLong(LottoRank::getPrizeMoney).sum();
        long realCost = LottoMachine.LOTTO_PRICE.getAmount() * lottoRanks.size();
        assertThat(totalProfitRate).isEqualTo((double) realTotalPrizeMoney / realCost);
    }
}
