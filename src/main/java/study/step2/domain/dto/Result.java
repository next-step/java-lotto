package study.step2.domain.dto;

import java.util.List;

import study.step2.domain.Rank;

public class Result {

    private final Rank rank;
    private final int winningCount;

    public Result(Rank rank, int counts) {
        this.rank = rank;
        this.winningCount = counts;
    }

    public static int sumWinningAmount(List<Result> results) {
        return results.stream()
            .mapToInt(Result::calculate)
            .sum();
    }

    private int calculate() {
        return rank.amount() * winningCount;
    }

    public static float revenue(int winingAmount, int purchaseAmount) {
        return (float) winingAmount / purchaseAmount;
    }

    public Rank rank() {
        return rank;
    }

    public int winningCount() {
        return winningCount;
    }

}
