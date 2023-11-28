package lotto.domain;

public class LottosResult {
    private final Lottos lottos;
    private final WinningLotto winningLotto;

    public LottosResult(Lottos lottos, WinningLotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
    }

    public double profitRate() {
        double profits = Ranking.ranked()
                .stream()
                .mapToDouble(this::profitsPerRanking)
                .sum();
        return profitRateFormat(profits / payment(lottos.get().size()));
    }

    private int profitsPerRanking(Ranking ranking) {
        return countByRanking(ranking) * ranking.profit();
    }

    public int countByRanking(Ranking ranking) {
        return (int) lottos.get()
                .stream()
                .filter(lotto -> lotto.ranking(winningLotto) == ranking)
                .count();
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
