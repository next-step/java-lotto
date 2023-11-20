package camp.nextstep.edu.lottery;

import java.util.ArrayList;
import java.util.List;

public class Lotteries {

    public static final int LOTTERY_PRICE = 1000;
    private final List<Lottery> lotteries;
    
    public Lotteries(int money) {
        this.lotteries = new ArrayList<>();

        int lotteryCount = money / LOTTERY_PRICE;
        for (int i = 0; i < lotteryCount; i++) {
            this.lotteries.add(LotteryGenerator.create());
        }
    }

    public Lotteries(List<Lottery> lotteries) {
        this.lotteries = lotteries;
    }

    public int count() {
        return lotteries.size();
    }

    public int count1stPrize(Lottery winningLottery) {
        final int FIRST_PRIZE_MATCHING_COUNT = 6;
        return countSameMatchingCount(winningLottery, FIRST_PRIZE_MATCHING_COUNT);
    }

    public int count3rdPrize(Lottery winningLottery) {
        final int THIRD_PRIZE_MATCHING_COUNT = 5;
        return countSameMatchingCount(winningLottery, THIRD_PRIZE_MATCHING_COUNT);
    }

    public int count4thPrize(Lottery winningLottery) {
        final int FOURTH_PRIZE_MATCHING_COUNT = 4;
        return countSameMatchingCount(winningLottery, FOURTH_PRIZE_MATCHING_COUNT);
    }

    public int count5thPrize(Lottery winningLottery) {
        final int FIFTH_PRIZE_MATCHING_COUNT = 3;
        return countSameMatchingCount(winningLottery, FIFTH_PRIZE_MATCHING_COUNT);
    }

    private int countSameMatchingCount(Lottery winningLottery, int targetCount) {
        return (int) lotteries.stream()
            .filter(lottery -> winningLottery.calcMatchingCount(lottery) == targetCount)
            .count();
    }

    public double calcReturnRate(Lottery winningLottery) {
        int usedMoney = lotteries.size() * LOTTERY_PRICE;
        int returnMoney = count1stPrize(winningLottery) * 2000000000;
        returnMoney += count3rdPrize(winningLottery) * 1500000;
        returnMoney += count4thPrize(winningLottery) * 50000;
        returnMoney += count5thPrize(winningLottery) * 5000;

        return (double) returnMoney / usedMoney;
    }
}
