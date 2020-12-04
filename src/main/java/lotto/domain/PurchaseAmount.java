package lotto.domain;

import lotto.constant.ErrorMessage;

import java.util.List;

public class PurchaseAmount {

    public static final int PRICE = 1000;
    private final int amount;

    public PurchaseAmount(List<Rank> ranks) {
        this(ranks.size() * PRICE);
    }

    public PurchaseAmount(int amount) {
        valid(amount);
        this.amount = amount;
    }

    private void valid(int amount) {
        if (amount < PRICE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_AMOUNT_ERROR);
        }
    }

    public int getLottoCount() {
        return amount / PRICE;
    }

    public double getRate(double allPrizeMoney) {
        return allPrizeMoney / amount;
    }

    public int minus(int amount) {
        return this.amount - amount;
    }

    public boolean canBuy(int size) {
        return amount - (size * PRICE) >= 0;
    }
}
