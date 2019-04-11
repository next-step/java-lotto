package lotto.domain;

import java.util.*;

public class LotteryNo {
    int number;

    public LotteryNo(int number) {
        checkLotteryNo(number);

        this.number = number;
    }

    private static void checkLotteryNo(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
    }

    public  static HashSet<LotteryNo> makeLotteryNos(List<Integer> numbers) {
        List<LotteryNo> lotteryNos = new ArrayList<>();

        for (Integer number : numbers) {
            lotteryNos.add(new LotteryNo(number));
        }

        return new HashSet<>(lotteryNos);
    }

    public static boolean isEqual(LotteryNo number, LotteryNo lotteryNo) {
        return lotteryNo.number == number.number;
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }
}
