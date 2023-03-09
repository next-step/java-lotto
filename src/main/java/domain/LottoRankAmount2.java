package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public enum LottoRankAmount2 {
    // FIRST(1, 2000000000),
    // SECOND(2, 30000000),
    // THIRD(3, 1500000),
    // FOURTH(4, 50000),
    // FIFTH(5, 5000),
    // SIXTH(6, 0);
    FIRST(1, Arrays.asList());

    private int rank;

    private List<Map<Integer, LottoBonusState>> lottoCases;

    private LottoRankAmount2(int rank, int amount) {
        this.rank = rank;
        this.amout = amount;
    }

    public int getAmount() {
        return this.amout;
    }

    public int getRank() {
        return this.rank;
    }
}
