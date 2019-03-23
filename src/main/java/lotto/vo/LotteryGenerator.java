package lotto.vo;

import lotto.utils.RandomUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LotteryGenerator {
    public static final int LOTTERY_NUMBER = 6;
    List lotteryNumbers;

    public LotteryGenerator() {
        lotteryNumbers = new ArrayList<>();
        lottoMake();
    }

    private void lottoMake() {
        while (lotteryNumbers.size() < LOTTERY_NUMBER) {
            addLotteryNumber();
        }
    }

    private void addLotteryNumber() {
        int randomNumber = RandomUtils.random();
        if (!lotteryNumbers.contains(randomNumber))
            lotteryNumbers.add(randomNumber);
    }

    public List<Integer> lotteryNumbers() {
        Collections.sort(lotteryNumbers);
        return lotteryNumbers;
    }

    public BonusNumber addBonusNumber() {
        return new BonusNumber(lotteryNumbers);
    }
}
