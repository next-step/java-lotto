package step2.domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoRank {

    FOUR(3, 5000L),
    THREE(4, 50000L),
    TWO(5, 150_000L),
    ONE(6, 2_000_000_000L);

    private final long number;
    private final long money;

    LottoRank(long number, long money) {
        this.number = number;
        this.money = money;
    }

    public static Optional<LottoRank> findRank(long winNumberCount) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> isSameNumber(lottoRank, winNumberCount))
                .findAny();
    }

    private static boolean isSameNumber(LottoRank lottoRank, long winNumberCount) {
        return lottoRank.number == winNumberCount;
    }

    public long getMoney() {
        return money;
    }

    public long getNumber() {
        return number;
    }
}
