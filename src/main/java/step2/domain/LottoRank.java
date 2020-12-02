package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public enum LottoRank {

    FIVE(3, 5_000L),
    FOUR(4, 50_000L),
    THREE(5, 150_000L),
    TWO(5, 30_000_000L),
    ONE(6, 2_000_000_000L),
    ZERO(0, 0L);

    private final long number;
    private final long money;

    LottoRank(long number, long money) {
        this.number = number;
        this.money = money;
    }

    public static LottoRank valueOf(long countOfMatch, boolean matchBonus) {
        if (isTwo(countOfMatch, matchBonus)) {
            return LottoRank.TWO;
        }

        return findRank(countOfMatch);
    }

    private static boolean isTwo(long countOfMatch, boolean matchBonus) {
        return countOfMatch == LottoRank.TWO.getNumber() && matchBonus;
    }

    public static LottoRank findRank(long winNumberCount) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> isSameNumber(lottoRank, winNumberCount))
                .findFirst().orElse(ZERO);
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
