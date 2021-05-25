package step3.model;

import java.util.stream.IntStream;

public final class Price {
    private static final int MIN_VALUE = 1000;
    private static final String NOT_AVALIABLE = "가격은 0보다 크며, 1000단위만 가능합니다.";

    private Integer price;

    public Price(Integer price) {
        validation(price);
        this.price = price;
    }

    private void validation(int price) {
        if (isUnderMin(price) || isNotThousandUnit(price)) {
            throw new IllegalArgumentException(NOT_AVALIABLE);
        }
    }

    private boolean isNotThousandUnit(int price) {
        return (price % MIN_VALUE) != 0;
    }

    private boolean isUnderMin(int price) {
        return price < MIN_VALUE;
    }

    public IntStream getBuyCountStream() {
        return IntStream.range(0, price / MIN_VALUE);
    }

    public int value() {
        return price;
    }

}
