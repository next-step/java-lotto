package lotto.model.result;

import lotto.model.domain.Rank;

import java.util.Map;

public class LotteryGameResultDto {

    private static final int LOSS_STANDARD = 1;
    private final Map<Rank, Integer> result = ResultMapGenerator.init();
    private final int amount;

    public LotteryGameResultDto(int amount) {
        this.amount = amount;
    }

    public double getProfit() {
        return getTotalWinningPrice() / (double)amount;
    }

    public void plusResultCount(Rank rank) {
        if(result.containsKey(rank)) {
            this.result.put(rank, this.result.get(rank) + 1);
        }
    }

    public Map<Rank, Integer> getResults() {
        return this.result;
    }

    public boolean isLoss() {
        return getProfit() < LOSS_STANDARD;
    }

    private long getTotalWinningPrice() {
        return result.entrySet().stream()
                .mapToLong(map -> map.getKey().getWinningMoney() * map.getValue())
                .sum();
    }
}
