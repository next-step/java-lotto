package lottery.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LotteryNumberSet {
    private List<Integer> lotteryNumbers = new ArrayList<>();

    public LotteryNumberSet() {
        initLotteryNumber();
    }

    public List<Integer> getLotteryNumbers() {
        return this.lotteryNumbers;
    }

    private void initLotteryNumber() {
        for (int number = 1; number < 46; number++) {
            lotteryNumbers.add(number);
        }
    }

    private List<Integer> sort(List<Integer> suffledNumbers) {
        Collections.sort(suffledNumbers);
        return suffledNumbers;
    }

    private List<Integer> getIntegers(List<Integer> lotteryNumbers) {
        return lotteryNumbers.subList(0, 6);
    }

    List<Integer> suffle(List<Integer> lotteryNumbers) {
        Collections.shuffle(lotteryNumbers);
        return lotteryNumbers;
    }

    public List<Integer> extractRandomNumbers() {
        return sort(getIntegers(suffle(lotteryNumbers)));
    }
}
