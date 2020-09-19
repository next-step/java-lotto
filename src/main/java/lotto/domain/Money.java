package lotto.domain;

public class Money {
    public static final int LOTTO_DEFAULT_PRICE = 1000;
    private int lottoPrice;

    public Money(int price) {
        minimumPriceCheck(price);
        this.lottoPrice = price;
    }

    private void minimumPriceCheck(int price) {
        if(price < LOTTO_DEFAULT_PRICE) {
            throw new IllegalArgumentException("로또의 최소 금액은 1000원 입니다.");
        }
    }

    public int getLottoCount() {
        return lottoPrice / LOTTO_DEFAULT_PRICE;
    }

    public int getLottoPrice() {
        return lottoPrice;
    }
}
