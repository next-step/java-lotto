package lotto.model;

public class Price {

    private final static int LOTTO_PRICE = 1000;
    private static final String LIMIT_PRICE_INPUT = "1000원 이상의 금액을 입력해주세요";

    private final int price;

    public Price(int price) {
        validatePrice(price);
        this.price = price;
    }

    private void validatePrice(int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException(LIMIT_PRICE_INPUT);
        }
    }

    public int calculateTotalCount(){
        return price/LOTTO_PRICE;
    }
}
