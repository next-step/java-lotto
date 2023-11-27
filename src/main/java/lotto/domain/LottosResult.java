package lotto.domain;

public class LottosResult {
    private final Lottos lottos;
    private final Lotto winningLotto;

    public LottosResult(Lottos lottos, Lotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
    }

    public double profitRate() {
        double profits = 0;
        for (Ranking ranking : Ranking.ranked()) {
            profits += profitsPerRanking(ranking);
        }
        return profitRateFormat(profits / payment(lottos.lottos().size()));
    }

    private int profitsPerRanking(Ranking ranking) {
        return countByRanking(ranking) * ranking.profit();
    }

    public int countByRanking(Ranking ranking) {
        return (int) lottos.lottos().stream().filter(lotto -> lotto.matchingCount(winningLotto) == ranking.matchingCount()).count();
    }

    private int payment(int amount) {
        return amount * Lotto.PRICE;
    }

    private double profitRateFormat(double result) {
        return Math.floor(result * 100) / 100.0;
    }

    public boolean isLoss() {
        return profitRate() < 1;
    }
}
