package lotto.domain;

import java.util.Arrays;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public enum LottoResult {

    FIRST(2000000000, 6, "원"),
    SECOND(1500000, 5, "원"),
    THIRD(50000, 4, "원"),
    FORTH(5000, 3, "원");

    private final int money;
    private final int matchCount; // TODO 적절한 단어고민
    private final String unitDescription;

    LottoResult(int money, int matchCount, String unitDescription) {
        this.money = money;
        this.matchCount = matchCount;
        this.unitDescription = unitDescription;
    }

    public static LottoResult from(int inputMatchCount) {
        return Arrays.stream(values())
                .filter(value -> value.matchCount == inputMatchCount)
                .findAny()
                .orElse(null);
    }

    public int getMoney() {
        return money;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getUnitDescription() {
        return unitDescription;
    }
}
