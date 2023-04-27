package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotteries {
    private final List<Lottery> lotteries;

    public Lotteries(final int lotteryCount) {
        this.lotteries = new ArrayList<>(lotteryCount);
        generateLottery(lotteryCount);
    }

    public Lotteries(final int lotteryCount, List<Integer> winningNumbers) {
        this.lotteries = new ArrayList<>(lotteryCount);
        generateLottery(lotteryCount);
//        this.winningNumbers = new WinningNumbers(winningNumbers);
    }

    public Lotteries(Lottery lottery, List<Integer> winningNumbers) {
        this.lotteries = new ArrayList<>(1);
        this.lotteries.add(lottery);
//        this.winningNumbers = new WinningNumbers(winningNumbers);
    }

    private void generateLottery(int lotteryCount) {
        for (int i = 0; i < lotteryCount; i++) {
            lotteries.add(new Lottery());
        }
    }

    public List<Integer> calculateResult(List<Integer> winningNumbers) {
        return lotteries.stream()
                .map(lottery -> lottery.matchedCount(winningNumbers))
                .filter(matchedCount -> matchedCount >= 3)
                .collect(Collectors.toList());
    }

    public int size() {
        return lotteries.size();
    }

    public List<Lottery> getLotteries() {
        return Collections.unmodifiableList(lotteries);
    }
}
