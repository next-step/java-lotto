package step2;

import java.util.*;

public class LotteryAwardSystem {

    private final Lottos lottos;
    private final WinningNumbers winningNumbers;
    private final int money;
    private final WinnersCountManager winnersCountManager = new WinnersCountManager();
    private double profitRate;

    public LotteryAwardSystem(Lottos lottos, WinningNumbers winningNumbers, int money) {
        this.lottos = lottos;
        this.money = money;
        this.winningNumbers = winningNumbers;
        calculateWinnersCount();
        calculateProfitRate();
    }

    private void calculateWinnersCount() {
        lottos.getLottos().forEach(this::recordWinnerCount);
    }

    private void recordWinnerCount(Lotto lotto) {
        PrizeLevel prizeLevel = getPrizeLevel(lotto);
        winnersCountManager.recordWinnerCount(prizeLevel);
    }

    private PrizeLevel getPrizeLevel(Lotto lotto) {
        int matchedCount = lotto.matchedNumbersCount(winningNumbers.getNumbers());
        boolean hasBonus = lotto.hasBonus(winningNumbers.getBonusNumber());

        if (matchedCount == 5 && hasBonus) {
            return PrizeLevel.SECOND;
        }

        return Arrays.stream(PrizeLevel.values())
                .filter(level -> level.getMatchCount() == matchedCount)
                .findFirst()
                .orElse(PrizeLevel.MISS);
    }

    private void calculateProfitRate() {
        double totalPrize = calculateSumPrize();
        profitRate = Math.floor(totalPrize / (double) money * 100) / 100;
    }

    private double calculateSumPrize() {
        return Arrays.stream(PrizeLevel.values())
                .mapToDouble(level -> level.getPrizeAmount() * winnersCountManager.getWinnerCount(level))
                .sum();
    }

    public Map<PrizeLevel, Integer> getWinnersCountMap() {
        return winnersCountManager.getWinnersCountMap();
    }

    public double getProfitRate() {
        return profitRate;
    }
}
