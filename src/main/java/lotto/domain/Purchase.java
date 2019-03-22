package lotto.domain;

import lotto.Utils;

public class Purchase {
    private final String purchase;
    public static final int LOTTO_PRICE = 1_000;

    public Purchase(String purchase) {
        if(Utils.toInt(purchase) < LOTTO_PRICE) {
            throw new IllegalArgumentException();
        }
        this.purchase = purchase;
    }

    public int purchaseQuantity() {
        return Utils.toInt(purchase) / LOTTO_PRICE;
    }

    public double earningsRate(int totalPrize) {
        double result = (double)totalPrize / Double.parseDouble(purchase);
        int tmp = (int)(result * 100);
        result = (double)tmp / 100;
        return result;
    }
}