package domain;

public class LottoStatistics {
    private static final int LOTTO_PRICE = 1000;
    private final Lottos lottos;
    private final Lotto winningLotto;

    public LottoStatistics(Lottos lottos, Lotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
    }

    public int calculateThreeNumbersCount() {
        return lottos.calculateNumbers(winningLotto, 3);
    }

    public int calculateFourNumbersCount() {
        return lottos.calculateNumbers(winningLotto, 4);
    }

    public int calculcateFiveNumbersCount() {
        return lottos.calculateNumbers(winningLotto, 5);
    }

    public int calculcateSixNumbersCount() {
        return lottos.calculateNumbers(winningLotto, 6);
    }

    public double statistics() {
        return ((calculateThreeNumbersCount() * 5000)
                + (calculateFourNumbersCount() * 50000)
                + (calculcateFiveNumbersCount() * 1500000)
                + (calculcateSixNumbersCount() * 2000000000)) / (lottos.size() * LOTTO_PRICE);
    }

}
