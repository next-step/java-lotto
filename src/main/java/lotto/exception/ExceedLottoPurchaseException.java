package lotto.exception;

import static lotto.constant.Constant.LOTTO_PRICE;

public class ExceedLottoPurchaseException extends RuntimeException {
    private static final String MESSAGE = "구매할 수동 로또 개수에 비해 구입 금액이 부족합니다.";

    public ExceedLottoPurchaseException(int manualLottoCount, int price) {
        super(MESSAGE);
        System.out.println("Manual Lotto Purchase Price: " + (manualLottoCount * LOTTO_PRICE) + ", price: " + price);
    }

}
