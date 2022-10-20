package lotto;

public class Price {
    private static final int MINIMUM_PRICE = 0;
    private final int price;

    public Price(int price) {
        validateOutOfRange(price);
        this.price = price;
    }

    private void validateOutOfRange(int price) {
        if(price <= MINIMUM_PRICE) {
            throw new LotteryGameException(ErrorCode.OUT_OF_RANGE_PRICE);
        }
    }
}
