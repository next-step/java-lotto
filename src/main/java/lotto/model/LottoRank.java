package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum LottoRank {

    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    MISS(0, 0);


    private final long rank;
    private final int money;

    LottoRank(long rank, int money) {
        this.rank = rank;
        this.money = money;
    }

    public int money() {
        return this.money;
    }

    public long rank() {
        return this.rank;
    }

    public static LottoRank valueOf(long rank, long matchBonusNumber) {
        if (matchBonusNumber > 0) {
            return Arrays.stream(values())
                .sorted(Collections.reverseOrder())
                .filter(lottoRank -> lottoRank.rank() == rank)
                .findAny()
                .orElse(LottoRank.MISS);
        }
        return Arrays.stream(values())
            .filter(lottoRank -> lottoRank.rank() == rank)
            .findAny()
            .orElse(LottoRank.MISS);
    }

}
