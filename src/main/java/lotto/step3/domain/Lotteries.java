package lotto.step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotteries {

    private List<Lotto> lotteries = new ArrayList<>();

    public Lotteries(int orderCount) {
        createLotteries(orderCount);
    }

    public Lotteries(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    public int totalCountOfMatch(Lotto winningNumbers, int count) {
        return (int) lotteries.stream()
                .filter(lotto -> lotto.isCountOfMatch(winningNumbers, count))
                .count();
    }

    public int totalSecondPrizeWinners(Lotto winningNumbers, int bonusBall) {
        return (int) lotteries.stream()
                .filter(lotto -> lotto.isSecondPrizeWinner(winningNumbers, bonusBall))
                .count();
    }

    public boolean isSecondPrizeWinners(Lotto winningNumbers, int bonusBall) {
        return lotteries.stream()
                .anyMatch(lotto -> lotto.isSecondPrizeWinner(winningNumbers, bonusBall));
    }

    public int totalPrizeMoney(Lotto winningNumbers, int bonusBall) {
        return lotteries.stream()
                .mapToInt(lotto -> lotto.calculatePrizeMoney(winningNumbers, bonusBall))
                .sum();
    }

    private void createLotteries(int orderCount) {
        for (int i = 0; i < orderCount; i++) {
            lotteries.add(new Lotto());
        }
    }

}
