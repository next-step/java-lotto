package lottery.domain.constant;

import static java.util.Arrays.stream;

import java.util.HashMap;
import java.util.Map;

public enum Rank {
    FIRST(6, 2_000_000_000),

    SECOND(5, 1_500_000),

    THIRD(4, 50_000),

    FOURTH(3, 5_000),

    MISS(0, 0)
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

    public static Rank getRankByCountOfMatch(int countOfMatch) {
        if(COUNT_OF_MATCHES.containsKey(countOfMatch)) {
            return COUNT_OF_MATCHES.get(countOfMatch);
        }
        return MISS;
    }
}
