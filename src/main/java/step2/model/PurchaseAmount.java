package step2.model;

import static step2.model.LottoValidator.*;

public class PurchaseAmount {
    private int purchaseAmount;
    private int lottoCount;
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_AMOUNT = 1000;

    public PurchaseAmount(String amount) {
        isValid(amount);
        this.lottoCount = calcLottoCount(amount);
        this.purchaseAmount = calcPurchaseAmount();
    }

    private int calcPurchaseAmount() {
        return lottoCount * LOTTO_PRICE;
    }

    private int calcLottoCount(String amount) {
        return Integer.parseInt(amount) / LOTTO_PRICE;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    private void isOverMinAmount(String amount) {
        if (Integer.parseInt(amount) < MIN_AMOUNT) {
            throw new IllegalArgumentException("로또를 사기에 부족한 금액입니다. 1000원이상 입력해주세요.");
        }
    }

    private void isValid(String amount) {
        isBlank(amount);

        amount = amount.trim();
        isDigit(amount);

        isOverMinAmount(amount);
    }
}
