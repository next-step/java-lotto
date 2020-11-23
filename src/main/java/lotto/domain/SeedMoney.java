package lotto.domain;

import java.util.Objects;

/**
 * Created By mand2 on 2020-11-19.
 */
public class SeedMoney {

    private final int money;

    public static final int MONEY_PER_ROUND = 1000; // 게임 당 게임비용
    public static final int ZERO = 0; // 게임 당 게임비용

    public static final String MESSAGE_NON_NULL = "빈칸을 입력할 수 없습니다.";
    public static final String MESSAGE_NUMBER = "구입금액은 숫자로만 입력해주세요.";
    public static final String MESSAGE_MONEY_TIMES = "한 게임당 비용은 1000원 입니다.";
    public static final String MESSAGE_ROUND_TIMES = "최소 한 게임 이상 입력해주시기 바랍니다.";

    private SeedMoney(int money) {
        this.money = money;
    }

    public static SeedMoney from(String money) {
        isNull(money);
        int amount = isNumber(money);

        return from(amount);
    }

    public static SeedMoney from(int money) {
        isPositive(money);
        isDivided(money);

        return new SeedMoney(money);
    }

    public int amount() {
        return this.money;
    }

    public int round() {
        return this.money / MONEY_PER_ROUND;
    }

    private static void isNull(String money) {
        if (Objects.isNull(money) || money.isEmpty()) {
            throw new NullPointerException(MESSAGE_NON_NULL);
        }
    }

    private static int isNumber(String money) {
        try {
            return Integer.valueOf(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MESSAGE_NUMBER);
        }
    }

    private static void isPositive(int amount) {
        if (ZERO >= amount) {
            throw new IllegalArgumentException(MESSAGE_ROUND_TIMES);
        }
    }

    private static void isDivided(int amount) {
        if (amount % MONEY_PER_ROUND != ZERO) {
            throw new IllegalArgumentException(MESSAGE_MONEY_TIMES);
        }
    }


}
