package step2.model;

import java.util.ArrayList;
import java.util.List;

import step2.constant.Prize;

public class Lotteries {

    private int lotteryCount;
    private final List<Lottery> lotteries;

    public Lotteries() {
        lotteryCount = 0;
        lotteries = new ArrayList<>();
    }

    public int getLotteryCount() {
        return lotteryCount;
    }

    public void setLotteryCount(int lotteryCount) {
        this.lotteryCount = lotteryCount;
    }

    public void keep(Lottery lottery) {
        lotteries.add(lottery);
    }

    public List<Prize> getPirzeList(Winning winning) {
       List<Prize> result = new ArrayList<>();
        for (Lottery lottery : lotteries) {
            result.add(find(lottery, winning));
        }

        return result;
    }

    private Prize find(Lottery lottery, Winning winning) {
        for (int number : lottery.getNumbers()) {
            winning.setWinCount(number);
        }

        return winning.getPrizes();
    }
}
