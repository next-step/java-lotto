package lotto.constant;

import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    OUT_OF_RANK(0, 0);

    private final int countOfMatch;
    private final int winningMoney;

    LottoRank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static LottoRank valueOf(int countOfMatch, boolean bonus) {
        if (isSecondRank(countOfMatch, bonus)) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(rank -> !rank.equals(SECOND))
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(OUT_OF_RANK);
    }

    public int getCountOfMatch() {
        return this.countOfMatch;
    }

    public int getWinningMoney() {
        return this.winningMoney;
    }

    public static List<LottoRank> valuesWithWinningRank() {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> !rank.equals(OUT_OF_RANK))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    private static boolean isSecondRank(int countOfMatch, boolean bonus) {
        return countOfMatch == SECOND.countOfMatch && bonus;
    }
}
