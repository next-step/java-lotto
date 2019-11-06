package step2_bak;

import java.util.Arrays;

public enum Prize {
    FIRST_PRIZE(6, 2000000000), SECOND_PRIZE(5, 1500000), THIRD_PRIZE(4, 50000), FORTH_PRIZE(3, 5000);

    private int correctCount;
    private int money;

    Prize(int correctCount, int money) {
        this.correctCount = money;
        this.money = money;
    }

    public static int getMoney(int prize) {
        return Arrays.stream(Prize.values()).filter(p -> p.isSamePrize(prize))
                .findFirst().get().money;
    }

    public boolean isSamePrize(int correctCount) {
        return this.correctCount == correctCount;
    }

}
