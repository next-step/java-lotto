package lotto;

import static java.util.Arrays.stream;

public enum Grade {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    BANG(0, 0);

    private static final Grade[] CACHED_GRADES = Grade.values();

    private final int matchCount;
    private final long reward;

    Grade(int matchCount, long reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static Grade from(int matchCount) {
        return stream(CACHED_GRADES)
                .filter(grade -> grade.matchCount == matchCount)
                .findAny()
                .orElse(BANG);
    }

    public long getReward() {
        return reward;
    }
}
