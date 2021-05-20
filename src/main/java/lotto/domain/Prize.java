package lotto.domain;

import java.util.Arrays;
import java.util.function.Function;

/**
 * 당첨.
 */
public enum Prize {
    MISS(0, 0, (match) -> match < 3),
    FOURTH(3, 5000, (match) -> match == 3),
    THIRD(4, 50_000, (match) -> match == 4),
    SECOND(5, 1_500_000, (match) -> match == 5),
    FIRST(6, 2000_000_000, (match) -> match == 6);

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
    private final Function<Integer, Boolean> matcher;

    Prize(int match, int amount, Function<Integer, Boolean> matcher) {
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
    public static Prize of(int matchCount) {
        return Arrays.stream(values())
                .filter(v -> v.match(matchCount))
                .findFirst()
                .orElse(Prize.MISS);
    }

    public int getMatch() {
        return match;
    }

    public int getAmount() {
        return amount;
    }

    private Boolean match(int matchCount) {
        return matcher.apply(matchCount);
    }
}
