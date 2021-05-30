package lotto;

public class Buyer {
    private static final String PURCHASE_EXCEPTION_MESSAGE = "구입금액은 1000원 이상의 금액을 " +
            "입력해야 합니다.";

    private LottoPrice lottoPrice = new LottoPrice();
    private int purchase;

    public Buyer(int purchase) {
        validatePurchase(purchase);
        this.purchase = purchase;
    }

    public int buyLotto() {
        return this.purchase / lottoPrice.getLottoPrice();
    }

    private void validatePurchase(int purchase) {
        if (purchase < 1000) {
            throw new IllegalArgumentException(PURCHASE_EXCEPTION_MESSAGE);
        }
    }
}
