package lotto.domain;

import lotto.view.OutputView;

public class LottoPrice {

    private static final int ERROR_WRONG_LOTTO_PRICE = 0;
    private static final int LOTTO_PRICE = 1000;

    private final int price;

    public LottoPrice(int price) {
        this.price = price;
        validateLottoPrice();
    }

    private void validateLottoPrice() {
        if (price % LOTTO_PRICE != ERROR_WRONG_LOTTO_PRICE) {
            throw new IllegalArgumentException(OutputView.ERROR_WRONG_LOTTO_PRICE);
        }
    }

    public int calculateLottoNumber() {
        return price / LOTTO_PRICE;
    }

    public int getPrice() {
        return price;
    }
}
