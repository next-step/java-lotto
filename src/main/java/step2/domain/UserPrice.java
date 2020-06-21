package step2.domain;

import step2.view.ErrorMessages;

public class UserPrice {

    private static final int LOTTO_PRICE = 1000;
    private static final int MINIMUM_USER_PRICE = 1000;
    private static final int MAXIMUM_USER_PRICE = 100000;
    private static final int EMPTY_COUNT = 0;

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
        return getLottoCount(EMPTY_COUNT);
    }

    public int getLottoCount(int manualLottoCount) {
        if (price < LOTTO_PRICE) {
            return 0;
        }
        return (int) Math.floor(price) / LOTTO_PRICE - manualLottoCount;
    }

    @Override
    public String toString() {
        return "UserPrice{" +
            "price=" + price +
            '}';
    }
}
