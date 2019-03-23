package lottery.domain;

import java.util.ArrayList;
import java.util.List;

public class LotteryNumberSet {
    public static List<Integer> lotteryNumbers = null;

    public LotteryNumberSet() {
        initLotteryNumber();
    }

    private void initLotteryNumber() {
        lotteryNumbers = new ArrayList<>();
        for (int number = 1; number < 46; number++) {
            lotteryNumbers.add(number);
        }
    }
}
