package lottogame.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoGameService {
    private Lottos lottos;
    private Integer buyAmount;
    private Map<Rank, Integer> winningResultsByRank = new HashMap<>();


    public LottoGameService(Lottos lottos, Integer buyAmount) {
        this.lottos = lottos;
        this.buyAmount = buyAmount;
    }

    public double calculatePrizeAmount(Lotto winingLotto) {
        double winningAmount = 0;
        for (Lotto lotto : lottos.getLottos()) {
            int winningCount = lotto.countMatchingNumbers(winingLotto);
            Rank rank = Rank.from(winningCount);
            winningResultsByRank.merge(rank, 1, (v1, v2) -> v1 + v2);
            winningAmount += rank.getAmount();
        }
        return winningAmount / buyAmount;
    }

    public Map<Rank, Integer> getWinningResultsByRank() {
        return winningResultsByRank;
    }
}
