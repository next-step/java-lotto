package lotto.domain;

public class Money {
    public static final int LOTTO_PRICE = 1000;

    public long lottoQuantity(long fee) {
        return fee / LOTTO_PRICE;
    }
}
