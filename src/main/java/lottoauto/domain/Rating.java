package lottoauto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum Rating {
    LOSING(0, 0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private final static Map<Integer, Rating> ratingCache = new HashMap<>();

    static {
        Arrays.stream(values()).forEach(rating -> ratingCache.put(rating.matchCount, rating));
    }

    private final int matchCount;
    private final int reward;

    Rating(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static Rating from(int matchCount) {
        return Optional.ofNullable(ratingCache.get(matchCount)).orElse(Rating.LOSING);
    }

    public int rewardAmount(int number) {
        return this.reward * number;
    }

    @Override
    public String toString() {
        return matchCount + "개 일치 (" + reward + "원)";
    }
}
