package lotto.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

/**
 * 당첨.
 */
public enum Prize {
    MISS(0, 0, (match, bonusNumber) -> match < 3),
    FIFTH(3, 5000, (match, bonusNumber) -> match == 3),
    FOURTH(4, 50_000, (match, bonusNumber) -> match == 4),
    THIRD(5, 150_0000, (match, bonusNumber) -> match == 5 && !bonusNumber),
    SECOND(5, 30_000_000, (match, bonusNumber) -> match == 5 && bonusNumber),
    FIRST(6, 2000_000_000, (match, bonusNumber) -> match == 6);

    /**
     * 당첨 일치 갯수.
     */
    private final int match;
    /**
     * 당첨액.
     */
    private final int amount;
    /**
     * 당선 일치여부 조건.
     */
    private BiFunction<Integer, Boolean, Boolean> matcher;

    Prize(int match, int amount, BiFunction<Integer, Boolean, Boolean> matcher) {
        this.match = match;
        this.amount = amount;
        this.matcher = matcher;
    }

    /**
     * 일치하는 갯수에 해당하는 상금을 리턴한다.
     *
     * @param matchCount 번호 일치 갯수
     * @return 맞춘 갯수에 해당하는 상금
     */
    public static Prize of(int matchCount, boolean bonusNumber) {
        return Arrays.stream(values())
                .filter(v -> v.match(matchCount, bonusNumber))
                .findFirst()
                .orElse(Prize.MISS);
    }

    public int getMatch() {
        return match;
    }

    public int getAmount() {
        return amount;
    }

    private Boolean match(int matchCount, boolean bonusNumber) {
        return matcher.apply(matchCount, bonusNumber);
    }
}
