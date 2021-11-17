package domain;

import java.util.Objects;

public class Store {
    private static final String PRICE_NULL_ERROR_MESSAGE = "error : 로또 금액은 Null 값을 입력할수 없습니다.";
    private static final String PRICE_MIN_ERROR_MESSAGE = "error : 로또 최소가격은 1000원 입니다.";
    private static final int LOTTERY_PRICE_MIN = 1000;
    private final int price;
    private final int lotteryCount;

    public Store(int price) {
        checkPriceNull(price);
        validPriceMin(price);
        this.price = price;
        this.lotteryCount = calculateNumber();
    }

    private void checkPriceNull(int price) {
        if (Objects.isNull(price)) {
            throw new IllegalArgumentException(PRICE_NULL_ERROR_MESSAGE);
        }
    }

    private void validPriceMin(int price) {
        if (price < LOTTERY_PRICE_MIN) {
            throw new IllegalArgumentException(PRICE_MIN_ERROR_MESSAGE);
        }
    }

    public int calculateNumber() {
        return discard() / LOTTERY_PRICE_MIN;
    }

    public int discard() {
        return Math.round(calculate(price)) * LOTTERY_PRICE_MIN;
    }

    private int calculate(int price) {
        return price / LOTTERY_PRICE_MIN;
    }

    public int price() {
        return price;
    }

    public int lotteryCount() {
        return lotteryCount;
    }
}
