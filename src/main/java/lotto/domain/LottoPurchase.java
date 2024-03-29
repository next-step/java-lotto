package lotto;

public class LottoPurchase {
    private static final int LOTTO_PRICE = 1000;

    public static int purchase(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구매 금액은 1000원 단위로 입력해주세요.");
        }
        return money / LOTTO_PRICE;
    }
}
