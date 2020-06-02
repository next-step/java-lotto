package lotto.domain.rank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRevenueCalculatorTest {

    @Test
    void calculatorTest_수익률_계산() {
        List<LottoRank> lottoRanks = new ArrayList<>();
        lottoRanks.add(LottoRank.FIFTH);
        lottoRanks.add(LottoRank.MISS);

        LottoRevenueCalculator lottoRevenueCalculator = new LottoRevenueCalculator(lottoRanks);
        assertThat(lottoRevenueCalculator.getRevenueRate()).isEqualTo("2.50");
    }

    @Test
    void calculatorTest_당첨갯수_계산() {
        List<LottoRank> lottoRanks = new ArrayList<>();
        lottoRanks.add(LottoRank.FIFTH);
        lottoRanks.add(LottoRank.MISS);
        lottoRanks.add(LottoRank.MISS);
        lottoRanks.add(LottoRank.MISS);
        lottoRanks.add(LottoRank.SECOND);
        lottoRanks.add(LottoRank.SECOND);
        lottoRanks.add(LottoRank.SECOND);
        lottoRanks.add(LottoRank.FIRST);

        LottoRevenueCalculator lottoRevenueCalculator = new LottoRevenueCalculator(lottoRanks);
        Map<LottoRank, Integer> lottoRankCount = lottoRevenueCalculator.getLottoRankCount();

        assertThat(lottoRankCount.get(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(lottoRankCount.get(LottoRank.SECOND)).isEqualTo(3);
        assertThat(lottoRankCount.get(LottoRank.FIRST)).isEqualTo(1);
    }
}
