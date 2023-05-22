package lottery.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lotteries {
    public static final Integer BONUS_BALL_CHANCE_NUMBER = 5;
    public static final Integer BONUS_BALL_CHANCE_NUMBER_RANK = 6;
    public static final Integer RANK_LENGTH = 8;
    public static final List<Integer> matchNumberToRank = Arrays.asList(0, 1, 2, 3, 4, 5, 7);

    public static List<Lottery> buy(Integer price, LotteryStrategy lotteryStrategy) {
        int number = calculateNumberOfLottery(price);
        List<Lottery> lotteries = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            lotteries.add(lotteryStrategy.generate());
        }
        return lotteries;
    }

    private static int calculateNumberOfLottery(Integer price) {
        return price / LotteryPrice.VALUE;
    }

    public static LotteryResult calculateResult(List<Lottery> lotteries, WinLottery winLottery) {
        List<Integer> numberOfMatchNumbers = lotteries.stream().map((lottery) -> calculateMatchCount(lottery, winLottery)).collect(Collectors.toList());
        List<Boolean> hasBonusBalls = lotteries.stream().map((lottery) -> calculateHasBonusBall(lottery, winLottery)).collect(Collectors.toList());
        List<Integer> winLotteryNumbers = new ArrayList<>();
        for (int i = 0; i < RANK_LENGTH; i++) {
            winLotteryNumbers.add(0);
        }
        for (int i = 0; i < numberOfMatchNumbers.size(); i++) {
            checkBonusBallAndAdd(hasBonusBalls.get(i), numberOfMatchNumbers.get(i), winLotteryNumbers);
        }
        return new LotteryResult(winLotteryNumbers, lotteries.size());
    }

    private static void checkBonusBallAndAdd(Boolean hasBonusBall, int number, List<Integer> winLotteryNumbers) {
        if (hasBonusBall && number == BONUS_BALL_CHANCE_NUMBER) {
            winLotteryNumbers.set(BONUS_BALL_CHANCE_NUMBER_RANK, winLotteryNumbers.get(BONUS_BALL_CHANCE_NUMBER_RANK) + 1);
            return;
        }
        winLotteryNumbers.set(matchNumberToRank.get(number), winLotteryNumbers.get(matchNumberToRank.get(number)) + 1);
    }

    private static Boolean calculateHasBonusBall(Lottery lottery, WinLottery winLottery) {
        List<LotteryNumber> lotteryNumbers = lottery.numbers();
        LotteryNumber bonusBallValue = winLottery.bonusBall().value();

        return lotteryNumbers.contains(bonusBallValue);
    }


    private static int calculateMatchCount(Lottery lottery, WinLottery winLottery) {
        List<LotteryNumber> lotteryNumbers = lottery.numbers();
        List<LotteryNumber> winLotteryNumbers = winLottery.numbers();

        return (int) lotteryNumbers.stream()
                .filter(winLotteryNumbers::contains)
                .count();
    }
}
