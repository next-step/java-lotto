package lotto.domain;

public class LottoResult {
    private final Ranks ranks;
    private final Amount totalPayment;

    public LottoResult(Ranks ranks, Amount totalPayment) {
        this.ranks = ranks;
        this.totalPayment = totalPayment;
    }

    public Ranks ranks() {
        return ranks;
    }

    public float roi() {
        return ranks.totalWinningMoney().divide(totalPayment);
    }
}
