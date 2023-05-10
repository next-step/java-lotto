package lotto;

import java.util.*;

public enum KLottoRank {

    FIFTH(3, false, 5000),
    FOURTH(4, false, 5000),
    THIRD(5, false, 15000000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 200000000);

    private final int count;
    private final boolean bonus;
    private final int prize;

    public int getCount() {
        return count;
    }

    public int getPrize() {
        return prize;
    }

    public boolean getBonus() {
        return bonus;
    }

    public static KLottoRank find(int matchCount, boolean existBonus) {
        KLottoRank rank =  Arrays.stream(values())
                .filter(kLottoRank -> kLottoRank.getCount() == matchCount)
                .filter(kLottoRank -> kLottoRank.getBonus() == existBonus)
                .findFirst()
                .orElse(null);

        return rank;
    }

    KLottoRank(final int count, final boolean bonus, final int prize) {
        this.count = count;
        this.bonus = bonus;
        this.prize = prize;
    }
}
