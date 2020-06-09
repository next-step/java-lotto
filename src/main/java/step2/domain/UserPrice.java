package step2.domain;

import static step2.Constants.LOTTO_PRICE;

import step2.view.ErrorMessages;

public class UserPrice {

    private static final int MINIMUM_USER_PRICE = 1000;
    private static final int MAXIMUM_USER_PRICE = 100000;
    private int price;

    public UserPrice(int price) throws IllegalArgumentException {
        this.price = price;
        validateUserPrice();
    }

    public int getPrice() {
        return price;
    }

    private void validateUserPrice() throws IllegalArgumentException {
        if (price < MINIMUM_USER_PRICE || price > MAXIMUM_USER_PRICE) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_USER_PRICE);
        }
    }

    public int getLottoCount() {
        if (price < LOTTO_PRICE) {
            return 0;
        }
        return (int) Math.floor(price) / LOTTO_PRICE;
    }

    private long getTotalCashPrize(LottoSheet lottoSheet, WinningLotto winningLotto) {
        long totalCashPrize = lottoSheet.getLottos().stream()
            .mapToLong(lotto -> lotto.getPrize(winningLotto).getCashPrize()).sum();
        return totalCashPrize;
    }

    public double getEarningRate(LottoSheet lottoSheet, WinningLotto winningLotto) {
        return (double) getTotalCashPrize(lottoSheet, winningLotto) / price;
    }
}
