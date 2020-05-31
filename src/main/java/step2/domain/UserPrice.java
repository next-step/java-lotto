package step2.domain;

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
        if (this.price < MINIMUM_USER_PRICE || this.price > MAXIMUM_USER_PRICE) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_USER_PRICE);
        }
    }
}
