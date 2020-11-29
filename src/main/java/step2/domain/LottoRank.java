package step2.domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoRank {

    FOUR(3, LottoConstant.FOUR_MONEY),
    THREE(4, LottoConstant.THREE_MONEY),
    TWO(5, LottoConstant.TWO_MONEY),
    ONE(6, LottoConstant.ONE_MONEY);

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
