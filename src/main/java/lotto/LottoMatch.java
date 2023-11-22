package lotto;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoMatch {
    ZERO(0, false,0),
    ONE(1, false, 0),
    TWO(2, false, 0),
    THREE(3, false,5000),
    FOUR(4, false, 50000),
    FIVE(5, false,1500000),
    FIVE_BONUS(5, true,  30000000),
    SIX(6, false,2000000000);

//    private static final Map<Integer, LottoMatch> INTEGER_TO_ENUM =
//            Stream.of(values()).collect(Collectors.toMap(LottoMatch::matchCount, e -> e));

    private final int matchCount;

    private final boolean isBonus;

    private final long amount;

    LottoMatch(int matchCount, boolean isBonus, long amount) {
        this.matchCount = matchCount;
        this.isBonus = isBonus;
        this.amount = amount;
    }

    public static LottoMatch fromInt(int matchCount, boolean isBonus) {
        for (LottoMatch lottoMatch : LottoMatch.values()) {
            if(lottoMatch.matchCount() == matchCount && lottoMatch.isBonus() == isBonus) {
                return lottoMatch;
            }
        }

        return LottoMatch.ZERO;
    }

    public static int matchesCount(int matchCount, boolean isBonus, LottoMatchResult lottoMatchResult) {
        long matchedCount =
                lottoMatchResult.lottoMatches()
                        .stream()
                        .filter(lottoMatch -> lottoMatch.matchCount() == matchCount && lottoMatch.isBonus() == isBonus)
                        .count();

        return (int) matchedCount;
    }

    public int matchCount() {
        return this.matchCount;
    }

    public boolean isBonus() {
        return this.isBonus;
    }

    public long amount() {
        return this.amount;
    }
}
