package lotto.vo;

import lotto.utils.RandomUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryGenerator {
    public static final int LOTTERY_NUMBER = 6;
    List<Integer> lotteryNumbers;

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

    public Lottery lotteryNumbers() {
        Collections.sort(lotteryNumbers);
        printLottoNumber();
        return Lottery.toLotteries(lotteryNumbers);
    }

    private void printLottoNumber() {
        String result = lotteryNumbers.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(",", "[", "]"));
        System.out.println(result);
    }

    public BonusNumber addBonusNumber() {
        return new BonusNumber(lotteryNumbers);
    }
}
