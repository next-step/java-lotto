package lottogame;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoMatch {
    THREE_MATCH(3, 5_000),
    FOUR_MATCH(4, 50_000),
    FIVE_MATCH(5, 1_500_000),
    FIVE_BONUS_MATCH(7, 30_000_000),
    SIX_MATCH(6, 2_000_000_000);

    private final int matchCount;
    private final int prize;

    LottoMatch(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoMatch find(int matchCount) {
        return MAP.get(matchCount);
    }

    private static final Map<Integer, LottoMatch> MAP =
        Collections.unmodifiableMap(Stream.of(values())
            .collect(Collectors.toMap(LottoMatch::getMatchCount, Function.identity())));


    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
