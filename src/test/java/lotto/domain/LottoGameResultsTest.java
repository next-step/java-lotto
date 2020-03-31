package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static lotto.domain.Constant.PRICE_PER_GAME;
import static org.assertj.core.api.Assertions.assertThat;

class LottoGameResultsTest {

    @DisplayName("1개가 일치하면 상금은 0원 이다.")
    @Test
    public void matchedOnePrizeTest() {
        List<LottoRank> lottoRanks = Arrays.asList(LottoRank.ONE);
        LottoGameResults lottoGameResults = new LottoGameResults(lottoRanks);

        BigDecimal winningPrizeSum = lottoGameResults.getWinningPrizeSum();

        assertThat(winningPrizeSum.intValue()).isEqualTo(LottoRank.ONE.getWinningPrize());
    }

    @DisplayName("2개가 일치하면 상금은 0원 이다.")
    @Test
    public void matchedTwoPrizeTest() {
        List<LottoRank> lottoRanks = Arrays.asList(LottoRank.TWO);
        LottoGameResults lottoGameResults = new LottoGameResults(lottoRanks);

        BigDecimal winningPrizeSum = lottoGameResults.getWinningPrizeSum();

        assertThat(winningPrizeSum.intValue()).isEqualTo(LottoRank.TWO.getWinningPrize());
    }

    @DisplayName("3개가 일치하면 상금은 5000원 이다.")
    @Test
    public void matchedThreePrizeTest() {
        List<LottoRank> lottoRanks = Arrays.asList(LottoRank.THREE);
        LottoGameResults lottoGameResults = new LottoGameResults(lottoRanks);

        BigDecimal winningPrizeSum = lottoGameResults.getWinningPrizeSum();

        assertThat(winningPrizeSum.intValue()).isEqualTo(LottoRank.THREE.getWinningPrize());
    }

    @DisplayName("3개 일치 티켓이 2장이면 상금은 5000원 이다.")
    @Test
    public void twoMatchedThreePrizeTest() {
        List<LottoRank> lottoRanks = Arrays.asList(LottoRank.THREE, LottoRank.THREE);
        LottoGameResults lottoGameResults = new LottoGameResults(lottoRanks);

        BigDecimal winningPrizeSum = lottoGameResults.getWinningPrizeSum();

        assertThat(winningPrizeSum.intValue()).isEqualTo(LottoRank.THREE.getWinningPrize() * 2);
    }

    @DisplayName("4개가 일치하면 상금은 50000원 이다.")
    @Test
    public void matchedFourPrizeTest() {
        List<LottoRank> lottoRanks = Arrays.asList(LottoRank.FOUR);
        LottoGameResults lottoGameResults = new LottoGameResults(lottoRanks);

        BigDecimal winningPrizeSum = lottoGameResults.getWinningPrizeSum();

        assertThat(winningPrizeSum.intValue()).isEqualTo(LottoRank.FOUR.getWinningPrize());
    }

    @DisplayName("5개가 일치하면 상금은 1_500_000원 이다.")
    @Test
    public void matchedFivePrizeTest() {
        List<LottoRank> lottoRanks = Arrays.asList(LottoRank.FIVE);
        LottoGameResults lottoGameResults = new LottoGameResults(lottoRanks);

        BigDecimal winningPrizeSum = lottoGameResults.getWinningPrizeSum();

        assertThat(winningPrizeSum.intValue()).isEqualTo(LottoRank.FIVE.getWinningPrize());
    }

    @DisplayName("5개가 일치하고 보너스번호도 일치하면 상금은 300_000_000원 이다.")
    @Test
    public void matchedFiveBonusPrizeTest() {
        List<LottoRank> lottoRanks = Arrays.asList(LottoRank.FIVE_BONUS);
        LottoGameResults lottoGameResults = new LottoGameResults(lottoRanks);

        BigDecimal winningPrizeSum = lottoGameResults.getWinningPrizeSum();

        assertThat(winningPrizeSum.intValue()).isEqualTo(LottoRank.FIVE_BONUS.getWinningPrize());
    }

    @DisplayName("6개가 일치하면 상금은 2_000_000_000원 이다.")
    @Test
    public void matchedSixPrizeTest() {
        List<LottoRank> lottoRanks = Arrays.asList(LottoRank.SIX);
        LottoGameResults lottoGameResults = new LottoGameResults(lottoRanks);

        BigDecimal winningPrizeSum = lottoGameResults.getWinningPrizeSum();

        assertThat(winningPrizeSum.intValue()).isEqualTo(LottoRank.SIX.getWinningPrize());
    }

    @DisplayName("결과중 각 당첨 랭크별 개수를 구할 수 있다")
    @Test
    public void getEachRankCountTotalTest() {
        List<LottoRank> lottoRanks = Arrays.asList(
                LottoRank.SIX, LottoRank.FIVE, LottoRank.FIVE_BONUS, LottoRank.FOUR, LottoRank.FOUR,
                LottoRank.THREE, LottoRank.THREE, LottoRank.THREE, LottoRank.TWO, LottoRank.TWO, LottoRank.ONE
        );

        LottoGameResults lottoGameResults = new LottoGameResults(lottoRanks);

        long oneTotal = lottoGameResults.getEachRankCountTotal(LottoRank.ONE);
        long twoTotal = lottoGameResults.getEachRankCountTotal(LottoRank.TWO);
        long threeTotal = lottoGameResults.getEachRankCountTotal(LottoRank.THREE);
        long fourTotal = lottoGameResults.getEachRankCountTotal(LottoRank.FOUR);
        long fiveTotal = lottoGameResults.getEachRankCountTotal(LottoRank.FIVE);
        long fiveBonusTotal = lottoGameResults.getEachRankCountTotal(LottoRank.FIVE_BONUS);
        long sixTotal = lottoGameResults.getEachRankCountTotal(LottoRank.SIX);

        assertThat(oneTotal).isEqualTo(1);
        assertThat(twoTotal).isEqualTo(2);
        assertThat(threeTotal).isEqualTo(3);
        assertThat(fourTotal).isEqualTo(2);
        assertThat(fiveTotal).isEqualTo(1);
        assertThat(fiveBonusTotal).isEqualTo(1);
        assertThat(sixTotal).isEqualTo(1);
    }

    @DisplayName("1게임(1000원) 샀을 때 5등(3개 일치) 당첨 1개 로또 수익률 계산 테스트")
    @Test
    public void lottoProfitRateTest() {
        List<LottoRank> lottoRanks = Arrays.asList(LottoRank.THREE);
        LottoGameResults lottoGameResults = new LottoGameResults(lottoRanks);

        BigDecimal profitRate = lottoGameResults.getProfitRate();
        int expected = LottoRank.THREE.getWinningPrize() / PRICE_PER_GAME;

        assertThat(profitRate.intValue()).isEqualTo(expected);
    }

    @DisplayName("10게임(10000원) 샀을 때 2등 당첨(5개 일치 + 보너스 번호 일치) 1개 로또 수익률 계산 테스트")
    @Test
    public void lottoProfitRateAtFiveBonusTest() {
        List<LottoRank> lottoRanks = Arrays.asList(LottoRank.FIVE_BONUS);
        LottoGameResults lottoGameResults = new LottoGameResults(lottoRanks);

        BigDecimal profitRate = lottoGameResults.getProfitRate();
        int expected = LottoRank.FIVE_BONUS.getWinningPrize() / (lottoRanks.size() * PRICE_PER_GAME);

        assertThat(profitRate.intValue()).isEqualTo(expected);
    }

}
