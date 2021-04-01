package lotto.domain;

import lotto.exception.LottoException;

public class LottoBuyer {

    private static final String LOTTO_PURCHASE_AMOUNT_MIN = "로또의 최소 구매금액은 1000원입니다.";
    private static final String LOTTO_PURCHASE_AMOUNT_UNIT = "구매금액은 1000원 단위로 입력해주세요.";
    private static final String MANUAL_LOTTO_COUNT_MORE_THAN_ZERO = "수동 로또 구매수량은 0개 이상입니다.";
    private static final String MANUAL_LOTTO_COUNT_OVER_LOTTO_PURCHASE_COUNT = "수동 로또 구매수량은 로또 구매 금액을 넘을수 없습니다.";
    private static final int LOTTO_PURCHASE_AMOUNT_UNIT_PRICE = 1_000;
    private final int lottoPurchaseAmount;
    private final int lottoManualCount;

    private LottoBuyer(final int lottoPurchaseAmount, final int lottoManualCount) {
        validation(lottoPurchaseAmount, lottoManualCount);
        this.lottoPurchaseAmount = lottoPurchaseAmount;
        this.lottoManualCount = lottoManualCount;
    }

    public static LottoBuyer of(final int lottoPurchaseAmount, final int lottoManualCount) {
        return new LottoBuyer(lottoPurchaseAmount, lottoManualCount);
    }

    public int getLottoQuantity() {
        return lottoPurchaseAmount / LOTTO_PURCHASE_AMOUNT_UNIT_PRICE;
    }

    private void validation(int lottoPurchaseAmount, int lottoManualCount) {
        if (lottoPurchaseAmount < LOTTO_PURCHASE_AMOUNT_UNIT_PRICE) {
            throw new LottoException(LOTTO_PURCHASE_AMOUNT_MIN);
        }

        if (lottoPurchaseAmount % LOTTO_PURCHASE_AMOUNT_UNIT_PRICE > 0) {
            throw new LottoException(LOTTO_PURCHASE_AMOUNT_UNIT);
        }

        if (lottoManualCount < 0) {
            throw new LottoException(MANUAL_LOTTO_COUNT_MORE_THAN_ZERO);
        }

        if ((lottoPurchaseAmount / LOTTO_PURCHASE_AMOUNT_UNIT_PRICE) < lottoManualCount) {
            throw new LottoException(MANUAL_LOTTO_COUNT_OVER_LOTTO_PURCHASE_COUNT);
        }
    }
}
