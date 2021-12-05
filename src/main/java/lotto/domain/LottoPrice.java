package lotto.domain;

/**
 * 역할: 로또 지불액을 입력받아 티켓 수 추출
 */
public class LottoPrice {

    private static final int PRICE_PER_LOTTO = 1000;

    private final int purchaseAmount;

    public LottoPrice(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int realPurchaseAmount() {
        return numberOfTicket() * PRICE_PER_LOTTO;
    }

    public int numberOfTicket() {
        return purchaseAmount / PRICE_PER_LOTTO;
    }
}
