package step2;

import java.util.Arrays;

public enum Rank {

    FIRST(1, 6, 2000000000),
    SECOND(2, 5, 1500000),
    THIRD(3, 4, 50000),
    FORTH(4, 3, 5000);

    private int rank;
    private int match;
    private int reward;

    Rank(int rank, int match, int reward) {
        this.rank = rank;
        this.match = match;
        this.reward = reward;
    }

    public static Rank matches(int match) {
        return Arrays.stream(values())
                .filter(rank -> rank.match == match)
                .findFirst()
                .orElseThrow(NullPointerException::new);
    };
}
