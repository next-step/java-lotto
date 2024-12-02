import java.util.Arrays;
import java.util.Optional;

public enum Rank {
    UNRANKED(0,0),
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private final int matchCount;
    private final int money;

    Rank(int value, int money) {
        this.matchCount = value;
        this.money = money;
    }

    public static Rank from(boolean bonusMatched, MatchCount matchCount) {
        Optional<Rank> rank = Arrays.stream(Rank.values()).filter(r -> matchCount.is(r.matchCount)).findFirst();

        if (rank.isEmpty()) {
            return UNRANKED;
        }

        if (rank.get().matchCount == SECOND.matchCount && !bonusMatched) {
            return THIRD;
        }

        return rank.get();
    }

    public static int toMoney(Rank rank) {
        return rank.money;
    }
}
