import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final int TOTAL_PRICE;
    private Map<Rank, Integer> ranks;

    public LottoResult(List<Lotto> userLotto, WinningLotto winningLotto) {
        this.TOTAL_PRICE = userLotto.size() * LottoMoney.LOTTO_PRICE;
        ranks = new HashMap<>();
        createRanks(userLotto, winningLotto);
    }

    private void createRanks(List<Lotto> userLotto, WinningLotto winningLotto) {
        userLotto.stream()
                .forEach(lotto -> {
                    Rank rank = Rank.valueOf(winningLotto.getMatchNumber(lotto), winningLotto.isMatchBonusNumber(lotto));
                    ranks.put(rank, rankCount(rank) + 1);
                });

    }

    public double getProfit() {
        double sum = 0;
        for (Rank rank : ranks.keySet()) {
            sum += rank.getWinningMoney() * ranks.get(rank);
        }
        return Math.floor(sum / TOTAL_PRICE * 100) / 100.0;
    }

    public int rankCount(Rank rank) {
        if (!ranks.containsKey(rank)) {
            return 0;
        }
        return ranks.get(rank);
    }
}
