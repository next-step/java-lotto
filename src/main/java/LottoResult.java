import java.util.*;

public class LottoResult {
    private final int TOTAL_PRICE;
    private RankCount rankCount = new RankCount();;

    public LottoResult(List<Lotto> userLotto, WinningLotto winningLotto) {
        this.TOTAL_PRICE = userLotto.size() * LottoMoney.LOTTO_PRICE;
        createRanks(userLotto, winningLotto);
    }

    private void createRanks(List<Lotto> userLotto, WinningLotto winningLotto) {
        userLotto.stream()
                .forEach(lotto -> {
                    Rank rank = Rank.valueOf(winningLotto.getMatchNumber(lotto), winningLotto.isMatchBonusNumber(lotto));
                    rankCount.countPlusOne(rank);
                });
    }

    public double getProfit() {
        return Math.floor(rankCount.getWinningMoney() / TOTAL_PRICE * 100) / 100.0;
    }

    public int rankCount(Rank rank) {
        return rankCount.getRankCount(rank);
    }
}
