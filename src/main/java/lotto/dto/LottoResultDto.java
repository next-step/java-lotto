package lotto.dto;

import lotto.domain.winning.LottoWinningAmount;
import lotto.domain.winning.LottoWinningResult;
import lotto.domain.PurchaseAmount;

public class LottoResultDto {
    private WinningResult threeMatch;
    private WinningResult fourMatch;
    private WinningResult fiveMatch;
    private WinningResult sixMatch;
    private Double earningRate;

    private LottoResultDto(LottoWinningResult lottoWinningResult, PurchaseAmount purchaseAmount) {
        threeMatch = WinningResult.of(LottoWinningAmount.THREE_MATCH.getWinningAmount(), lottoWinningResult.getWinningCount(LottoWinningAmount.THREE_MATCH));
        fourMatch = WinningResult.of(LottoWinningAmount.FOUR_MATCH.getWinningAmount(), lottoWinningResult.getWinningCount(LottoWinningAmount.FOUR_MATCH));
        fiveMatch = WinningResult.of(LottoWinningAmount.FIVE_MATCH.getWinningAmount(), lottoWinningResult.getWinningCount(LottoWinningAmount.FIVE_MATCH));
        sixMatch = WinningResult.of(LottoWinningAmount.SIX_MATCH.getWinningAmount(), lottoWinningResult.getWinningCount(LottoWinningAmount.SIX_MATCH));
        earningRate = lottoWinningResult.getEarningRate(purchaseAmount);
    }

    public static LottoResultDto of(LottoWinningResult lottoWinningResult, PurchaseAmount purchaseAmount) {
        return new LottoResultDto(lottoWinningResult, purchaseAmount);
    }

    public static class WinningResult {
        private Long winningAmount;
        private Long ticketCount;

        private WinningResult(Long winningAmount, Long ticketCount) {
            this.winningAmount = winningAmount;
            this.ticketCount = ticketCount;
        }

        public static WinningResult of (Long winningAmount, Long ticketCount) {
            return new WinningResult(winningAmount, ticketCount);
        }

        public Long getWinningAmount() {
            return winningAmount;
        }

        public Long getTicketCount() {
            return ticketCount;
        }
    }

    public WinningResult getThreeMatch() {
        return threeMatch;
    }

    public WinningResult getFourMatch() {
        return fourMatch;
    }

    public WinningResult getFiveMatch() {
        return fiveMatch;
    }

    public WinningResult getSixMatch() {
        return sixMatch;
    }

    public Double getEarningRate() {
        return earningRate;
    }
}
