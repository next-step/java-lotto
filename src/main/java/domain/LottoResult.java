package domain;

import java.util.List;

public class LottoResult {
    private final int TOTAL_PRICE;
    private RankCount rankCount = new RankCount();

    public LottoResult(LottoPaper lottoPaper, WinningLotto winningLotto) {
        this.TOTAL_PRICE = lottoPaper.getLottoSetsSize() * LottoGame.TICKET_PRICE;
        calculateLottoRankCount(lottoPaper.getLottoSets(), winningLotto);
    }

    private void calculateLottoRankCount(List<LottoSet> lottoPaper, WinningLotto winningLotto) {
        lottoPaper.stream()
                .forEach(lottoSet -> {
                    Rank rank = Rank.valueOf(winningLotto.getMatchNumber(lottoSet), winningLotto.isMatchBonusNumber(lottoSet));
                    rankCount.plusCount(rank);
                });
    }

    public double getProfit() {
        return Math.floor(rankCount.getWinningMoney() / TOTAL_PRICE * 100) / 100.0;
    }

    public RankCount getLottoRankCount() {
        return this.rankCount;
    }

    public int getLottoRankCount(Rank rank) {
        return rankCount.getNumberOfRankCount(rank);
    }
}
