package lottoauto;

import java.util.Arrays;

public enum Rating {
    LOSING(0, 0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private int matchCount;
    private int reward;

    Rating(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static Rating from(int matchCount) {
        return Arrays.stream(values())
                .filter(rating -> rating.matchCount == matchCount)
                .findFirst().orElse(LOSING);
    }

    public int rewardAmount(int number) {
        return this.reward * number;
    }

    @Override
    public String toString() {
        return matchCount + "개 일치 (" + reward + "원)";
    }
}
