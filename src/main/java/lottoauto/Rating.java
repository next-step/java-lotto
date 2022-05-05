package lottoauto;

import java.util.Arrays;

public enum Rating {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    LOSING(0, 0);

    private int matchCount;
    private int reward;

    Rating(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static Rating from(int matchCount) {
        return Arrays.stream(values())
                .filter(rating -> rating.matchCount == matchCount)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("해당하는 등수 정보가 존재하지 않습니다."));
    }

    @Override
    public String toString() {
        return "Rating{" +
                "matchCount=" + matchCount +
                ", reward=" + reward +
                '}';
    }
}
