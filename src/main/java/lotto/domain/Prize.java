package lotto.domain;

import java.util.Arrays;

public enum Prize {
    FIRST(6, 2_000_000_000, 0),
    SECOND(5, 1_500_000, 0),
    THIRD(4, 50_000, 0),
    FOURTH(3, 5_000, 0);

    private final int matchCount;

    private final int prize;

    private int prizeCount;

    Prize(int matchCount, int prize, int prizeCount) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.prizeCount = prizeCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public int getPrizeCount() {
        return prizeCount;
    }

    public void increaseCount() {
        prizeCount++;
    }

    public static void increaseWinningCount(Lotto winningLotto, Lottoes lottoes) {
        for (Lotto lotto : lottoes.getLottoes()) {
            int matchCount = (int) lotto.getNumbers()
                    .stream()
                    .filter(
                            number -> winningLotto.getNumbers()
                                    .contains(number)
                    )
                    .count();

            Arrays.stream(Prize.values())
                    .filter(p -> p.matchCount == matchCount)
                    .findAny()
                    .ifPresent(Prize::increaseCount);
        }
    }

    public static double calculateEarningRate(int purchaseAmount) {
        double earn = Arrays.stream(Prize.values())
                .mapToInt(prize1 -> prize1.prize * prize1.prizeCount)
                .sum();

        return earn / purchaseAmount;
    }

    public static void clear() {
        for (Prize prize : Prize.values()) {
            prize.prizeCount = 0;
        }
    }
}
