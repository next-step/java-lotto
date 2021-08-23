package step2.model;

import static step2.model.LottoValidator.*;

public class PurchaseAmount {
    private int purchaseAmount;

    private static final int MIN_AMOUNT = 1000;
    private static final int LOTTO_PRICE = 1000;

    public PurchaseAmount(String amount) {
        isBlank(amount);
        isDigit(amount);
        isOverMinAmount(amount);
        this.purchaseAmount = changeToInt(amount);
        this.purchaseAmount = calcPurchaseAmount(getLottoCount());
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    private void isOverMinAmount(String amount) {
        if (changeToInt(amount) < MIN_AMOUNT) {
            throw new IllegalArgumentException("로또를 사기에 부족한 금액입니다. 1000원이상 입력해주세요.");
        }
    }

    public int getLottoCount() {
        return purchaseAmount / LOTTO_PRICE;
    }

    public int calcPurchaseAmount(int lottoCount) {
        return lottoCount * LOTTO_PRICE;
    }
}
