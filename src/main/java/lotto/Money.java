package lotto;

import java.util.regex.Pattern;

public class Money {
//
//    private static final String MONEY_NOT_VALID_MESSAGE = "유효한 입력이 아닙니다. 돈은 숫자여야 합니다.";
//    private static final Pattern MONEY_PATTERN = Pattern.compile("[0-9]+");
    private static final int DEFAULT_BUY_COUNT = 0;

    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public int countCanBuy(int unitPrice) {
        if (unitPrice <= 0) {
            return DEFAULT_BUY_COUNT;
        }

        return money / unitPrice;
    }
}
