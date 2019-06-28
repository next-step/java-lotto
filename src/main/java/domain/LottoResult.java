package domain;

import java.util.*;

public class LottoResult {
    private final int TOTAL_PRICE;
    private RankCount rankCount = new RankCount();

    public LottoResult(List<LottoSet> lottoPaper, WinningLotto winningLotto) {
        this.TOTAL_PRICE = lottoPaper.size() * LottoGame.TICKET_PRICE;
        calculateLottoRankCount(lottoPaper, winningLotto);
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