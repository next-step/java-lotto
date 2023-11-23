package lotto.domain;

import java.util.Arrays;

public enum Rank {

    MISS(0, 0, false),
    FIFTH(3, 5000, false),
    FOURTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000, false);

    static final int HIT_FICE_LOTTO_NUMBERS = 5;
    private final int rank;
    private final int amount;

    private final boolean bounusNumber;

    private Rank(int rank, int amount, boolean bounusNumber) {
        this.rank = rank;
        this.amount = amount;
        this.bounusNumber = bounusNumber;
    }

    public static Rank valueOf(int label, boolean bonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(win -> win.rank == label && win.bounusNumber == bonusNumber)
                .findFirst()
                .orElse(MISS);
    }
//
//    private Rank getRankSecond(int matchCount, boolean checkBonusNumber) {
//        if (matchCount == HIT_FICE_LOTTO_NUMBERS && checkBonusNumber) {
//            return Rank.SECOND;
//        }
//        return null;
//    }

    public int getRank() {
        return rank;
    }

    public int getAmount() {
        return amount;
    }

}
