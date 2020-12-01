package step2.domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoRank {

    FIVE(3, 5000L),
    FOUR(4, 50000L),
    THREE(5, 150_000L),
    TWO(5, 30_000_000L),
    ONE(6, 2_000_000_000L);

    private final long number;
    private final long money;

    LottoRank(long number, long money) {
        this.number = number;
        this.money = money;
    }

    public static LottoRank valueOf(long countOfMatch, boolean matchBonus) {
        Optional<LottoRank> rank = findRank(countOfMatch);
        if (!rank.isPresent()) {
            return null;
        }

        LottoRank lottoRank = rank.get();
        if (isWinningTwo(lottoRank, matchBonus)) {
            return LottoRank.TWO;
        }
        return lottoRank;
    }

    private static boolean isWinningTwo(LottoRank lottoRank, boolean matchBonus) {
        return lottoRank.isTwo(matchBonus);
    }

    private boolean isTwo(boolean matchBonus) {
        return this == LottoRank.THREE && matchBonus;
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
