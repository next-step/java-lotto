package lottogame.domain;

import lottogame.domain.lotto.Lottos;
import lottogame.domain.lotto.Rank;
import lottogame.domain.lotto.WinningLotto;

import java.util.HashMap;
import java.util.Map;

public class LottoGameService {
    private final Lottos lottos;
    private final Integer buyAmount;
    private Map<Rank, Integer> winningResultsByRank = new HashMap<>();


    public LottoGameService(Lottos lottos, Integer buyAmount) {
        this.lottos = lottos;
        this.buyAmount = buyAmount;
    }

    public double calculatePrizeAmount(WinningLotto winningLotto) {

        winningResultsByRank = lottos.calculateWinningStatistics(winningLotto);
        double totalPrizeAmount = lottos.calculateTotalPrizeAmount(winningLotto);

        return totalPrizeAmount / buyAmount;
    }

    public Map<Rank, Integer> getWinningResultsByRank() {
        return winningResultsByRank;
    }
}
