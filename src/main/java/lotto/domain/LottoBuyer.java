package lotto.domain;

import lotto.exception.LottoException;

public class LottoBuyer {

    private static final String LOTTO_PURCHASE_AMOUNT_MIN = "로또의 최소 구매금액은 1000원입니다.";
    private static final String LOTTO_PURCHASE_AMOUNT_UNIT = "구매금액은 1000원 단위로 입력해주세요.";
    private static final int LOTTO_PURCHASE_AMOUNT_UNIT_PRICE = 1_000;
    private final int lottoPurchaseAmount;

    private LottoBuyer(final int lottoPurchaseAmount) {
        validation(lottoPurchaseAmount);
        this.lottoPurchaseAmount = lottoPurchaseAmount;
    }

    public static LottoBuyer of(final int lottoPurchaseAmount) {
        return new LottoBuyer(lottoPurchaseAmount);
    }

    public int getLottoQuantity() {
        return lottoPurchaseAmount / LOTTO_PURCHASE_AMOUNT_UNIT_PRICE;
    }

    private void validation(int lottoPurchaseAmount) {
        if (lottoPurchaseAmount < LOTTO_PURCHASE_AMOUNT_UNIT_PRICE) {
            throw new LottoException(LOTTO_PURCHASE_AMOUNT_MIN);
        }

        if (lottoPurchaseAmount % LOTTO_PURCHASE_AMOUNT_UNIT_PRICE > 0) {
            throw new LottoException(LOTTO_PURCHASE_AMOUNT_UNIT);
        }
    }
}
