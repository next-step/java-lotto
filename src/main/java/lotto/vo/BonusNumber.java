package lotto.vo;

import lotto.utils.RandomUtils;

import java.util.List;

public class BonusNumber {
    public static final int INITIAL_NUMBER = 0;
    private int bonusNumber;

    public BonusNumber(List lotteryNumbers) {
        int randomNumber = RandomUtils.random();
        while (bonusNumber == INITIAL_NUMBER) {
            makeBonusNumber(lotteryNumbers, randomNumber);
        }
    }

    private void makeBonusNumber(List lotteryNumbers, int randomNumber) {
        if (!lotteryNumbers.contains(randomNumber)) {
            bonusNumber = randomNumber;
        }
    }
}
