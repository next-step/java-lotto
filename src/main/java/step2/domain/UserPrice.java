package step2.domain;

import static step2.Constants.LOTTO_PRICE;

import java.util.List;
import step2.view.ErrorMessages;

public class UserPrice {

    private static final int MINIMUM_USER_PRICE = 1000;
    private static final int MAXIMUM_USER_PRICE = 100000;
    private int price;

    public UserPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void validateUserPrice() throws IllegalArgumentException {
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

    private int getTotalCashPrize(List<UserLotto> lottos) {
        int totalCashPrize = lottos.stream().mapToInt(UserLotto::getCashPrice).sum();
        return totalCashPrize;
    }

    public double getEarningRate(List<UserLotto> lottos) {
        return (double) getTotalCashPrize(lottos) / price;
    }
}
