package lotto.domain;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public enum LottoResult {

    FIRST(2000000000, 6),
    SECOND(30000000, 5),
    THIRD(1500000, 5),
    FORTH(50000, 4),
    FIFTH(5000, 3);

    private final int money;
    private final int matchCount;

    LottoResult(int money, int matchCount) {
        this.money = money;
        this.matchCount = matchCount;
    }

    public static LottoResult from(int inputMatchCount, boolean isBonusBallMatch) {
        Arrays.stream(values())
                .filter(value -> value.matchCount == inputMatchCount)
                .map(Optional::ofNullable)
    }

    public int getMoney() {
        return money;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
