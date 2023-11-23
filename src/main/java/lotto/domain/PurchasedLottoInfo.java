package lotto.domain;

public class PurchasedLottoInfo {

    private final Lottos lottos;
    private final long totalCost;

    public PurchasedLottoInfo(Lottos lottos, long totalCost) {
        this.lottos = lottos;
        this.totalCost = totalCost;
    }
}
