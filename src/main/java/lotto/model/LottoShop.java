package lotto.model;

public class LottoShop {
    public static final int LOTTO_PRICE = 1000;

    public int buyChance(int money) {
        return money / LOTTO_PRICE;
    }

}
