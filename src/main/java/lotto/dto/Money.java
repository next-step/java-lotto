package lotto.dto;

public class Money {
    private final static int LOTTO_PRICE = 1_000;
    private static int money;

    public static void inputUserMoney(int userMoney) {
        if (userMoney < LOTTO_PRICE) {
            throw new IllegalArgumentException();
        }
        money = userMoney;
    }

    public static int getMoney() {
        return money;
    }
}
