package lotto.enumerate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false);

    private int countOfMatch;
    private int winningMoney;
    private boolean isNeedBonus;

    private Rank(int countOfMatch, int winningMoney, boolean isNeedBonus) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.isNeedBonus = isNeedBonus;
    }

    public static List<Rank> getOrderedRanks() {
        return Arrays
                .stream(Rank.values())
                .sorted(Comparator.comparing(Rank::getWinningMoney))
                .collect(Collectors.toList());
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public boolean getIsNeedBonus() {
        return isNeedBonus;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        return Arrays
                .stream(Rank.values())
                .filter(vo -> vo.getCountOfMatch() == countOfMatch)
                .filter(vo -> checkBonus(vo, matchBonus))
                .findAny()
                .orElse(null);
    }

    private static boolean checkBonus(Rank rank, boolean matchBonus) {
        if (rank.getIsNeedBonus()) {
            return matchBonus;
        }
        return true;
    }

}