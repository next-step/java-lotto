package lotto.domain;

public class LottoResult {
    private final Ranks ranks;
    private final Amount totalAmount;

    public LottoResult(Ranks ranks, Amount totalAmount) {
        this.ranks = ranks;
        this.totalAmount = totalAmount;
    }

    public Ranks ranks() {
        return ranks;
    }

    public float roi() {
        return ranks.totalWinningMoney().divide(totalAmount);
    }
}
