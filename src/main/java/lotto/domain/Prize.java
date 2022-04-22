package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


public enum Prize {

    EIGHTH(0, false, 0d),
    SEVENTH(1, false,  0d),
    SIXTH(2, false,  0d),
    FIFTH(3, false,  5000d),
    FOURTH(4, false,  50000d),
    THIRD(5, true,  1_500_000d),
    SECOND(5, true,  30_000_000d),
    FIRST(6, false,  2_000_000_000d);

    private int matchCount;
    private boolean shouldCheckBonus;
    private double earnings;

    Prize(int matchCount, boolean shouldCheckBonus, double earnings) {
        this.matchCount = matchCount;
        this.shouldCheckBonus = shouldCheckBonus;
        this.earnings = earnings;
    }

    public static Prize findPrizeByMatchCount(int matchCount, boolean containsBonus) {
        List<Prize> prizes = findPrizesByMatchCount(matchCount);

        Prize originalPrize = prizes.get(0);
        if (originalPrize.shouldCheckBonus && containsBonus) {
            return findPrizeOfMaxEarnings(prizes);
        }

        return originalPrize;
    }

    private static List<Prize> findPrizesByMatchCount(int matchCount) {
        List<Prize> prizes = Arrays.stream(Prize.values())
                .filter(prize -> prize.matchCount == matchCount)
                .sorted(Comparator.comparingDouble(Prize::getEarnings))
                .collect(Collectors.toList());

        if (prizes.isEmpty()) {
            throw new NoSuchElementException();
        }

        return prizes;
    }

    private static Prize findPrizeOfMaxEarnings(List<Prize> prizes) {
        return prizes.stream()
                .max(Comparator.comparingDouble(Prize::getEarnings))
                .orElseThrow(NoSuchElementException::new);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public double getEarnings() {
        return earnings;
    }

}
