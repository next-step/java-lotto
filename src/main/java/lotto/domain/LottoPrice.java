package lotto.domain;

public class LottoPrice {

    private static final int PRICE_PER_LOTTO = 1000;

    private final int purchaseAmount;

    public LottoPrice(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int numberOfTicket() {
        return purchaseAmount / PRICE_PER_LOTTO;
    }
}
