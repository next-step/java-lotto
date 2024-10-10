package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningResultsTest {
    @Test
    @DisplayName("LottoWinningResults 객체 생성 시 LottoWinningStatus 필드 개수만큼 winningResults가 초기화 된다.")
    void initLottoWinningResultsTest() {
        LottoWinningResults result = new LottoWinningResults();
        assertThat(result.getWinningResults())
                .hasSize(LottoWinningStatus.values().length);
    }

    @Test
    @DisplayName("getTotalWinningAmount 메서드가 로또 당첨 금액을 반환한다.")
    void getWinningAmountTest() {
        int winningAmountSum = LottoWinningStatus.THREE.getAmount() + LottoWinningStatus.FOUR.getAmount();
        LottoWinningResults result = new LottoWinningResults();
        result.incrementWinningResults(LottoWinningStatus.THREE.getWinningCount());
        result.incrementWinningResults(LottoWinningStatus.FOUR.getWinningCount());
        assertThat(result.getTotalWinningAmount())
                .isEqualTo(winningAmountSum);
    }

    @Test
    @DisplayName("getProfitRate 메서드가 로또 결과 수익률을 반환한다.")
    void getProfitRateTest() {
        LottoPurchasePrice lottoPurchasePrice = new LottoPurchasePrice(14_000);
        double totalWinningAmount = LottoWinningStatus.THREE.getAmount();
        double profitRate = Math.floor(totalWinningAmount / lottoPurchasePrice.getValue() * 100) / 100;
        LottoWinningResults result = new LottoWinningResults();
        result.incrementWinningResults(LottoWinningStatus.THREE.getWinningCount());
        assertThat(result.getProfitRate(lottoPurchasePrice))
                .isEqualTo(profitRate);
    }

    @Test
    @DisplayName("incrementWinningResults 메서드가 매개변수에 따라 일치하는 LottoWinningStatus의 count를 증가시킨다.")
    void incrementWinningResultsTest() {
        LottoWinningResults result = new LottoWinningResults();
        result.incrementWinningResults(3);
        LottoWinningResult threeMatchResult = result.getWinningResults().stream()
                .filter(winningResult -> winningResult.getLottoWinningStatus() == LottoWinningStatus.THREE)
                .findFirst()
                .get();
        assertThat(threeMatchResult.getCount())
                .isEqualTo(1);
    }
}