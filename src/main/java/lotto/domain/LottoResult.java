package lotto.domain;

import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> lottoResult;
    private final double profitRate;

    public LottoResult(Lottos lottos, Map<Rank, Integer> lottoResult) {
        this.lottoResult = lottoResult;
        this.profitRate = profitRate(lottos);
    }

    public int numberOfLotto(Rank rank) {
        return lottoResult.getOrDefault(rank, 0);
    }

    public double profitRate() {
        return profitRate;
    }

    private double profitRate(Lottos lottos) {
        double result = (double) totalWinningAmount() / lottos.amountOfLottos();
        return Math.floor(result * 100) / 100.0;
    }

    private int totalWinningAmount() {
        int sum = 0;
        for (Rank rank : lottoResult.keySet()) {
            sum = plusWinningAmount(sum, rank);
        }
        return sum;
    }

    private int plusWinningAmount(int sum, Rank rank) {
        int amount = rank.winningAmount();
        for (int i = 0; i < lottoResult.get(rank); i++) {
            sum += amount;
        }
        return sum;
    }

}
