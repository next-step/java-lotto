package step3.domain;

public class Price {

    private final int LOTTO_PRICE = 1000;
    private int price;

    public Price(int price) {
        validate(price);
        this.price = price;
    }

    private void validate(int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또 가격은 1000원 이상입니다.");
        }
    }

    public int lottoCount() {
        return this.price / LOTTO_PRICE;
    }

    public int getPrice() {
        return price;
    }

}
