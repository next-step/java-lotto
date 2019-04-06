package lotto.vo;

import java.util.Set;

public class LotteryNumber {
    private static final int LOTTERY_NUMBER = 6;
    Set<Integer> lotteryNumber;

    public LotteryNumber(Set<Integer> lotteryNumber) {
        if (lotteryNumber.size() < LOTTERY_NUMBER)
            throw new IllegalArgumentException();
        this.lotteryNumber = lotteryNumber;
    }

    public static LotteryNumber toObject(Set<Integer> integers) {
        return new LotteryNumber(integers);
    }
}
