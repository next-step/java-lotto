package domain;

import static domain.WinningStatistics.THRESHOLD;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public enum WinningPrizes {
    ZERO(0, false, 0, 0, count -> THRESHOLD),
    ONE(1, false,0, 0, count -> THRESHOLD),
    TWO(2, false, 5, 5_000, count -> THRESHOLD),
    THREE(3, false, 5, 5_000, count -> count),
    FOUR(4, false, 4, 50_000, count -> count),
    FIVE(5, false, 3, 1_500_000, count -> count),
    FIVE_BONUS(5, true, 2, 3_000_000, count -> count),
    SIX(6, false, 1, 2_000_000_000, count -> count);

    private static final int HASH_GENERATION_NUMBER = 31;
    private static final Map<Integer, WinningPrizes> WINNING_PRIZE_MATCHERS_MAP = new HashMap<>();


    private int numberOfCount;
    private boolean isBonusMatch;
    private int rank;
    private int prizeMoney;
    private Function<Integer, Integer> countSupplier;


    WinningPrizes(int numberOfCount, boolean isBonusMatch, int rank, int prizeMoney, Function<Integer, Integer> countSupplier) {
        this.numberOfCount = numberOfCount;
        this.isBonusMatch = isBonusMatch;
        this.rank = rank;
        this.prizeMoney = prizeMoney;
        this.countSupplier = countSupplier;
    }

    static {
        for (WinningPrizes value : WinningPrizes.values()) {
            WINNING_PRIZE_MATCHERS_MAP.put(getHashCode(value.numberOfCount, value.isBonusMatch), value);
        }
    }

    public static int getHashCode(int numberOfCount, boolean isBonusMatch) {
        int bonusNum = 0;
        if (isBonusMatch) {
            bonusNum = 1;
        }
        return numberOfCount * HASH_GENERATION_NUMBER + bonusNum;
    }

    public static WinningPrizes valueOf(int numberOfCount, boolean isBonusMatch) {
        isBonusMatch = checkBonus(numberOfCount, isBonusMatch);
        return WINNING_PRIZE_MATCHERS_MAP.get(getHashCode(numberOfCount, isBonusMatch));
    }

    private static boolean checkBonus(int numberOfCount, boolean isBonusMatch) {
        if (FIVE_BONUS.getNumberOfCount() != numberOfCount && isBonusMatch) {
            isBonusMatch = false;
        }
        return isBonusMatch;
    }

    public int calculatePrizeMoney(int count) {
        return prizeMoney * count;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }



    public int getNumberOfCount() {
        return countSupplier.apply(numberOfCount);
    }
}
