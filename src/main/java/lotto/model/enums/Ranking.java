package lotto.model.enums;

import java.util.Arrays;

public enum Ranking {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    private int count;
    private int reword;

    Ranking(int count, int reword) {

        this.count = count;
        this.reword = reword;
    }

    public static Ranking findRanking (int count) {
        try {
            return Arrays.stream(Ranking.values()).filter(r -> r.getCount() == count)
                    .findFirst().orElse(null);
        } catch (IllegalArgumentException iae) {
            return null;
        }
    }

    public int getCount() {
        return count;
    }

    public int getReword() {
        return reword;
    }
}
