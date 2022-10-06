package lotto.domain;

import java.util.Arrays;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public enum LottoResult {

    FIRST(2000000000, 6),
    SECOND(1500000, 5),
    THIRD(50000, 4),
    FORTH(5000, 3),
    NONE(0, 0);

    public static final String 단위 = "원";

    private final int money;
    private final int matchCount; // TODO 적절한 단어고민

    LottoResult(int money, int matchCount) {
        this.money = money;
        this.matchCount = matchCount;
    }

    public static LottoResult from(int inputMatchCount) {
        return Arrays.stream(values())
                .filter(value -> value.matchCount == inputMatchCount)
                .findAny()
                .orElse(NONE);
    }

    public int getMoney() {
        return money;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
