package lotto.domain.prize;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private static final Map<Integer, Rank> RANK_WITHOUT_SECOND = Collections.unmodifiableMap(Stream.of(values())
            .filter(not(rank -> rank.equals(Rank.SECOND)))
            .collect(Collectors.toMap(Rank::getCountOfMatch, Function.identity())));
    private int countOfMatch;
    private int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (isSecond(countOfMatch, matchBonus)) {
            return SECOND;
        }
        return Optional.ofNullable(RANK_WITHOUT_SECOND.get(countOfMatch)).orElse(MISS);
    }

    private static boolean isSecond(int countOfMatch, boolean matchBonus) {
        return countOfMatch == 5 && matchBonus;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int calculateTotalPrice(int winningCount) {
        return this.winningMoney * winningCount;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "countOfMatch=" + countOfMatch +
                ", winningMoney=" + winningMoney +
                '}';
    }
}
