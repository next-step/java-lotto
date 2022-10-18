package lotto.domain;

public class LottoPrice {

    private final int price;

    public LottoPrice(int price) {
        this.price = price;
    }

    public LottoPrice() {
        this(1000);
    }

    public int lottoCount(int money) {
        if (money < price) {
            return 0;
        }

        return money / price;
    }

    public int manualLottoCost(int money) {
        return money * price;
    }
}
