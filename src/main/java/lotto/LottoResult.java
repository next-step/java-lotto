package lotto;

public class LottoResult {

    private final Lottos myLottos;
    private final Lotto winningLotto;

    public LottoResult(Lottos myLottos, Lotto winningLotto) {
        this.myLottos = myLottos;
        this.winningLotto = winningLotto;
    }

    public int countOf(Prize prize) {
        return (int) myLottos.calculatePrizes(winningLotto).stream()
                .filter(p -> p == prize)
                .count();
    }

    public long totalPrize() {
        return myLottos.calculatePrizes(winningLotto).stream()
                .mapToLong(Prize::getMoney)
                .sum();
    }

    public double profitRate() {
        double profitRate = (double) totalPrize() / myLottos.purchaseAmount();
        return Math.floor(profitRate * 100) / 100;
    }
}
