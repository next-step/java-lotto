package autoLotto;

import java.util.EnumMap;

import static autoLotto.Rank.*;

public class GameResult {
    private double result;
    private EnumMap<Rank, Integer> rankCount = new EnumMap<>(Rank.class);

    public GameResult() {
        rankCount.put(FIRST, 0);
        rankCount.put(SECOND, 0);
        rankCount.put(THIRD, 0);
        rankCount.put(FOURTH, 0);
        rankCount.put(FIFTH, 0);
        rankCount.put(MISS, 0);
        result = 0.0;
    }

    public GameResult(double result) {
        this.result = result;
    }

    public void count(Rank rank) {
        rankCount.put(rank, plusOne(rank));
    }

    private int plusOne(Rank rank) {
        return rankCount.get(rank) + 1;
    }

    public double getResult() {
        return result;
    }

    public EnumMap<Rank, Integer> getRankCount() {
        return rankCount;
    }

    public void makeWinningStatistics(double totalAmount, int lottoAmount) {
        this.result = Math.floor((totalAmount / lottoAmount) * 100) / 100.0;
    }
}
