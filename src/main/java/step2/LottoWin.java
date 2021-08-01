package step2;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum LottoWin {
    NONE_WIN(0, m -> m < 3),
    THREE_MATCH(5000, m -> m == 3),
    FOUR_MATCH(50000, m -> m == 4),
    FIVE_MATCH(1500000, m -> m == 5),
    SIX_MATCH(2000000000, m -> m == 6);

    private final int prize;
    private final Predicate<Integer> matchCondition;

    LottoWin(int winPrize, Predicate<Integer> matchCondition) {
        this.prize = winPrize;
        this.matchCondition = matchCondition;
    }

    public static LottoWin getMatchWinResult(LottoEntry lottoEntry1, LottoEntry lottoEntry2) {
        int match = lottoEntry1.countMatch(lottoEntry2);

        return fromMatch(match).orElse(LottoWin.NONE_WIN);
    }

    private static Optional<LottoWin> fromMatch(int match) {
        return Stream.of(values())
                .filter(w -> w.matchCondition.test(match))
                .findFirst();
    }

    public int prize() {
        return this.prize;
    }
}
