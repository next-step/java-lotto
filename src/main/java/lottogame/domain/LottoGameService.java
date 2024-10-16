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

    public double calculatePrizeAmount(Lotto winningLotto, LottoNumber bonusNumber) {
        winningResultsByRank = lottos.calculateWinningStatistics(winningLotto, bonusNumber);
        double totalPrizeAmount = lottos.calculateTotalPrizeAmount(winningLotto, bonusNumber);

        return totalPrizeAmount / buyAmount;
    }

    public Map<Rank, Integer> getWinningResultsByRank() {
        return winningResultsByRank;
    }
}
