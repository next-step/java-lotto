package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public enum LottoResult {

    FIRST(2000000000, "6개 일치", (matchCount, isBonusNumberMatch) -> matchCount == 6),
    SECOND(30000000, "5개 일치, 보너스 볼 일치", (matchCount, isBonusNumberMatch) -> matchCount == 5 && isBonusNumberMatch),
    THIRD(1500000, "5개 일치", (matchCount, isBonusNumberMatch) -> matchCount == 5 && !isBonusNumberMatch),
    FORTH(50000, "4개 일치", (matchCount, isBonusNumberMatch) -> matchCount == 4),
    FIFTH(5000, "3개 일치", (matchCount, isBonusNumberMatch) -> matchCount == 3);

    private final int money;
    private final String description;
    private final BiPredicate<Integer, Boolean> resultMatcher;

    LottoResult(int money, String description, BiPredicate<Integer, Boolean> resultMatcher) {
        this.money = money;
        this.description = description;
        this.resultMatcher = resultMatcher;
    }

    public static LottoResult from(int inputMatchCount, boolean isBonusBallMatch) {
        return Arrays.stream(values())
                .filter(value -> value.resultMatcher.test(inputMatchCount, isBonusBallMatch))
                .findAny()
                .orElse(null);
    }

    public int getMoney() {
        return money;
    }

    public BiPredicate<Integer, Boolean> getResultMatcher() {
        return resultMatcher;
    }

    public String getDescription() {
        return description;
    }
}
