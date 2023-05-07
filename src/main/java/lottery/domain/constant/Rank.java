package lottery.domain.constant;

import static java.util.Arrays.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(6, 2_000_000_000),

    SECOND(5, 30_000_000),

    THIRD(5, 1_500_000),

    FOURTH(4, 50_000),

    FIFTH(3, 5_000),

    MISS(0, 0);
    ;

    private static final Map<Integer, Rank> COUNT_OF_MATCHES = new HashMap<>();

    static {
        stream(Rank.values())
                .forEach(rank -> COUNT_OF_MATCHES.put(rank.getCountOfMatch(), rank));
    }

    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static List<Rank> sortRanksByCountOfMatch() {
        return Arrays.stream(Rank.values())
                .sorted(Comparator.comparingInt(Rank::getWinningMoney))
                .filter(rank -> rank != Rank.MISS)
                .collect(Collectors.toList());
    }

    public static Rank getRankByCountOfMatch(int countOfMatch, boolean isWinningBonus) {
        if(isWinningBonus) {
            return SECOND;
        }

        if(isThird(countOfMatch)) {
            return THIRD;
        }

        if(COUNT_OF_MATCHES.containsKey(countOfMatch)) {
            return COUNT_OF_MATCHES.get(countOfMatch);
        }
        return MISS;
    }

    private static boolean isThird(int countOfMatch) {
        return countOfMatch == 5;
    }
}
