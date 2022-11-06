package lotto.domain;

public class Calculator {
    public static double calculate(Lottos lottos, RankCount rankCount) {
        int amount = lottos.amount();

        long winningAmount = rankCount.winningAmount();

        return Math.floor(((double) winningAmount / amount) * 100) / 100.0;
    }
}
