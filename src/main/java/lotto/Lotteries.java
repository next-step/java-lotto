package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotteries {
    /**
     * Lottery를 가지고 있는 일급 컬렉션
     *
     */
    private final List<Lottery> lotteries;
    private final List<Integer> winningNumbers;

    public Lotteries(final int lotteryCount) {
        this.lotteries = new ArrayList<>(lotteryCount);
        this.winningNumbers = null;
        generateLottery(lotteryCount);
    }

    public Lotteries(final int lotteryCount, List<Integer> winningNumbers) {
        this.lotteries = new ArrayList<>(lotteryCount);
        generateLottery(lotteryCount);
        this.winningNumbers = winningNumbers;
    }

    public Lotteries(Lottery lottery, List<Integer> winningNumbers) {
        this.lotteries = new ArrayList<>(1);
        this.lotteries.add(lottery);
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> calculateResult() {
        int threeNumMatched = 0;
        int fourNumMatched = 0;
        int fiveNumMatched = 0;
        int sixNumMatched = 0;
        for (Lottery lottery : lotteries) {
            if (lottery.matchingCount(winningNumbers) == 3) {
                threeNumMatched++;
            }
            if (lottery.matchingCount(winningNumbers) == 4) {
                fourNumMatched++;
            }
            if (lottery.matchingCount(winningNumbers) == 5) {
                fiveNumMatched++;
            }
            if (lottery.matchingCount(winningNumbers) == 6) {
                sixNumMatched++;
            }
        }
        return List.of(threeNumMatched, fourNumMatched, fiveNumMatched, sixNumMatched);
    }

    private void generateLottery(int lotteryCount) {
        for (int i = 0; i < lotteryCount; i++) {
            lotteries.add(new Lottery());
        }
    }

    public int size() {
        return lotteries.size();
    }
}
