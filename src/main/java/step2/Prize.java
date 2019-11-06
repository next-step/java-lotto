package step2;

import java.util.Arrays;

public enum Prize {
    KRW_5_000(3, 5_000),
    KRW_50_000(4, 50_000),
    KRW_1_500_000(5, 1_5000_000),
    KRW_2_000_000_000(6, 2_000_000_000);

    private int correctCount;
    private int earningMoney;

    Prize(int correctCount, int earningMoney) {
        this.correctCount = correctCount;
        this.earningMoney = earningMoney;
    }

    public static int getPrice(int correctCount) {
        return Arrays.stream(values())
                .filter(prize -> prize.getCorrectCount() == correctCount).findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .getEarningMoney();
    }

    public int getCorrectCount() {
        return this.correctCount;
    }

    public int getEarningMoney() {
        return this.earningMoney;
    }

}
