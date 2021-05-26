package step3.model;

import java.util.stream.IntStream;

public final class Price {
    private static final int MIN_VALUE = 1000;
    private static final String NOT_AVALIABLE = "가격은 0보다 크며, 1000단위만 가능합니다.";
    private static final String NOT_AVALIABLE_MANUAL = "가격에 맞는 수동 구매 로또 수를 입력하세요";

    private Integer price;
    private Integer autoCount;
    private Integer manualCount;

    public Price(Integer price) {
        this(price, 0);
    }

    public Price(int price, int manual) {
        validation(price, manual);
        this.price = price;
        this.manualCount = manual;
        this.autoCount = price / MIN_VALUE - manual;

    }

    public IntStream getBuyManualCountStream() {
        return IntStream.range(0, manualCount);
    }

    public IntStream getBuyAutoCountStream() {
        return IntStream.range(0, autoCount);
    }

    public int value() {
        return price;
    }

    private void validation(int price, int manual) {
        validation(price);
        if (manual * MIN_VALUE > price) {
            throw new IllegalArgumentException(NOT_AVALIABLE_MANUAL);
        }
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

}
