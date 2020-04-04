package lotto.model;

import java.util.List;

public class Rank {
    private int rank;

    public Rank(final int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public static int calc(int num) {
        if (num == 6) {
            return 1;
        } else if (num == 5) {
            return 2;
        } else if (num == 4) {
            return 3;
        } else if (num == 3) {
            return 4;
        } else if (num == 2) {
            return 5;
        }
        return 6;
    }

}
