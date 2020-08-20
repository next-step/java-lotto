package step2.domain;

public class Money {

    private static final int UNIT_PRICE = 1000;

    public static int calculateLottoPurchaseCount(int money) {
        return money / UNIT_PRICE;
    }

}
