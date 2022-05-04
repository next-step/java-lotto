package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum LottoPrize {
    FIRST(new Match(6), new Amount(2_000_000_000)),
    SECOND(new Match(5), new Amount(1_500_000)),
    THIRD(new Match(4), new Amount(50_000)),
    FOURTH(new Match(3), new Amount(5_000)),
    NONE(new Match(0), new Amount(0));

    private static final Map<Match, LottoPrize> ENUM_MAP;

    private final Match match;
    private final Amount amount;

    LottoPrize(Match match, Amount amount) {
        this.match = match;
        this.amount = amount;
    }

    public static LottoPrize fromMatch(Match match) {
        if (!containMatch(match)) {
            return NONE;
        }
        return ENUM_MAP.get(match);
    }

    private static boolean containMatch(Match match) {
        return ENUM_MAP.containsKey(match);
    }

    static {
        ENUM_MAP = Arrays.stream(LottoPrize.values())
                .collect(Collectors.toUnmodifiableMap(LottoPrize::getMatch, lottoPrize -> lottoPrize));
    }

    public Match getMatch() {
        return match;
    }

    public long getAmount() {
        return amount.getAmount();
    }
}
