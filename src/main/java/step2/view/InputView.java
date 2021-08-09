package step2.view;

import step2.model.LottoException;

public class InputView {
    private static final int LOTTO_PRICE = 1000;

    public int setAmount(String amount) {
        //빈값 검사
        LottoException.isBlank(amount);

        //숫자인지 검사
        LottoException.isDigit(amount);

        //구매 최소금액 검사
        LottoException.isOverMin(amount);

        int purchaseAmount = Integer.parseInt(amount);
        int lottoCnt = purchaseAmount/LOTTO_PRICE;

        return lottoCnt;
    }
}
