package lottoauto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum Rating {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private static final Map<Integer, Rating> ratingCache = new HashMap<>();

    static {
        Arrays.stream(values()).forEach(rating -> ratingCache.put(rating.countOfMatch, rating));
    }

    private final int countOfMatch;
    private final int reward;

    Rating(int countOfMatch, int reward) {
        this.countOfMatch = countOfMatch;
        this.reward = reward;
    }

    public static Rating from(int countOfMatch) {
        return Rating.valueOf(countOfMatch, false);
    }

    public static Rating valueOf(int countOfMatch, boolean matchBonus) {
        if (matchBonus && countOfMatch == 5)
            return Rating.SECOND;
        if (!matchBonus && countOfMatch == 5)
            return Rating.THIRD;
        return Optional.ofNullable(ratingCache.get(countOfMatch)).orElse(Rating.MISS);
    }

    public int rewardAmount(int number) {
        return this.reward * number;
    }

    @Override
    public String toString() {
        if(this.equals(Rating.SECOND)) {
            return countOfMatch + "개 일치, 보너스 볼 일치 (" + reward + "원)";
        }
        return countOfMatch + "개 일치 (" + reward + "원)";
    }
}
