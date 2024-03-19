package step2;

import java.util.*;

public class LotteryAwardSystem {

    private final List<Lotto> lottos;
    private final Lotto winNumbers;
    private final int money;
    private final WinnersCountManager winnersCountManager = new WinnersCountManager();
    private double profitRate;

    public LotteryAwardSystem(List<Lotto> lottos, Lotto winNumbers, int money) {
        this.lottos = lottos;
        this.winNumbers = winNumbers;
        this.money = money;
        calculateWinnersCount();
        calculateProfitRate();
    }

    private void calculateWinnersCount() {
        for (Lotto lotto : lottos) {
            matchedNumbers(lotto);
        }
    }

    private void matchedNumbers(Lotto lotto) {
        List<Integer> tempNumbers = new ArrayList<>(lotto.getLottoNumbers());
        tempNumbers.retainAll(winNumbers.getLottoNumbers());
        int winsCount = tempNumbers.size();
        winnersCountManager.recordWinnerCount(winsCount);
    }

    private void calculateProfitRate() {
        double totalPrize = calculateSumPrize();
        profitRate = Math.floor(totalPrize / (double) money * 100) / 100;
    }

    private double calculateSumPrize() {
        double sum = 0;
        for (PrizeLevel level : PrizeLevel.values()) {
            int winCount = winnersCountManager.getWinnerCount(level.getMatchCount());
            sum += level.getPrizeAmount() * winCount;
        }
        return sum;
    }

    public Map<Integer, Integer> getWinnersCountMap() {
        return winnersCountManager.getWinnersCountMap();
    }

    public double getProfitRate() {
        return profitRate;
    }
}
