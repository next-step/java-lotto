package lotto.domain;

import java.util.Optional;

public enum Prize {

    //구조변경 : http://woowabros.github.io/tools/2017/07/10/java-enum-uses.html
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FORTH(4, 50_000),
    FIFTH(3, 5_000);

    private final int matchNumber;
    private final long prizeMoney;

    Prize(int matchNumber, int prizeMoney) {
        this.matchNumber = matchNumber;
        this.prizeMoney = prizeMoney;
    }

    public long calculatePrizeMoney(int[] matchNumbers, String name) {
        if (SECOND.name().equals(name)) {
            return 0;
        }

        return matchNumbers[matchNumber] * prizeMoney;
    }

    public static long calculateBonusMoney(int count) {
        return SECOND.prizeMoney * count;
    }

    public static long getPrizeMoney(int i, boolean bonus) {
        if (bonus) return Prize.SECOND.prizeMoney;
        return Prize.typeOf(i).prizeMoney;
    }

    private static Prize typeOf(int matchNumber) {
        Prize[] prizes = Prize.values();
        Prize result = null;

        for (Prize prize : prizes) {
            result = findPrize(result, prize, matchNumber);
        }

        return Optional.ofNullable(result).orElseThrow(IllegalArgumentException::new);
    }

    private static Prize findPrize(Prize result, Prize prize, int matchNumber) {
        if (matchNumber == 5) {
            return Prize.THIRD;
        }

        if (prize.matchNumber == matchNumber) {
            result = prize;
        }

        return result;
    }
}
