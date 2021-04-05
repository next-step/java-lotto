package step2.domain;

import java.util.Arrays;

public enum Prize {
    SIXTH(6, 2000000000),
    FIFTH(5, 1500000),
    FOURTH(4, 50000),
    THIRD(3, 5000);

    private int rank;
    private int prize;

    Prize(int rank, int prize) {
        this.rank = rank;
        this.prize = prize;
    }

    public static Prize of(int rank){
        return Arrays.stream(Prize.values())
                .filter(Prize -> Prize.getRank() == rank)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하지 않습니다."));
    }

    public int getRank() {
        return rank;
    }

    public int getPrize() {
        return prize;
    }
}
