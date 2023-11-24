package step4.model;

public class Price {

    public static final int EACH_LOTTO_PRICE = 1000;
    private final int payPrice;

    public Price(int payPrice) {
        this.payPrice = payPrice;
    }

    public int lottoCount() {
        if (this.payPrice % EACH_LOTTO_PRICE != 0 || payPrice / EACH_LOTTO_PRICE < 0) {
            throw new IllegalArgumentException("금액을 잘못 입력 하였습니다. 로또 한장의 가격은 " + EACH_LOTTO_PRICE + "원 입니다.");
        }

        return this.payPrice / EACH_LOTTO_PRICE;
    }

    public int getPayPrice() {
        return this.payPrice;
    }
}
