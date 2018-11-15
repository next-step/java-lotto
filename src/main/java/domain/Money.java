package domain;

public class Money {

    public static final int LOTTO_PRICE = 1_000;

    public static int calculateAmount(int money) {
        return money / LOTTO_PRICE;
    }
}
