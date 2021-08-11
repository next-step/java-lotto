package step2.model;

import static step2.model.LottoValidator.*;

public class PurchaseAmount {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_AMOUNT = 1000;

    private void isOverMinAmount(String amount) {
        if (Integer.parseInt(amount) < MIN_AMOUNT) {
            throw new IllegalArgumentException("로또를 사기에 부족한 금액입니다. 1000원이상 입력해주세요.");
        }
    }

    public int getLottoCount(String amount) {
        isBlank(amount);

        isDigit(amount);

        isOverMinAmount(amount);

        int purchaseAmount = getPurchaseAmount(amount);
        int lottoCount = purchaseAmount/LOTTO_PRICE;

        return lottoCount;
    }


    public int getPurchaseAmount(String amount) {
        return Integer.parseInt(amount);
    }
}
