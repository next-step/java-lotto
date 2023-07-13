package lotto.domain.statistics;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoMatch {
    THREE_MATCH(new LottoMatchKey(false, 3), 5_000),
    FOUR_MATCH(new LottoMatchKey(false, 4), 50_000),
    FIVE_MATCH(new LottoMatchKey(false, 5), 1_500_000),
    FIVE_BONUS_MATCH(new LottoMatchKey(true, 5), 30_000_000),
    SIX_MATCH(new LottoMatchKey(false, 6), 2_000_000_000),
    NONE_MATCH(new LottoMatchKey(true, 0), 0);

    private final LottoMatchKey lottoMatchKey;
    private final int prize;

    LottoMatch(LottoMatchKey lottoMatchKey, int prize) {
        this.lottoMatchKey = lottoMatchKey;
        this.prize = prize;
    }

    public static LottoMatch find(LottoMatchKey lottoMatchKey) {
        return Optional.ofNullable(MAP.get(lottoMatchKey)).orElse(NONE_MATCH);
    }

    private static final Map<LottoMatchKey, LottoMatch> MAP =
        Collections.unmodifiableMap(Stream.of(values())
            .collect(Collectors.toMap(LottoMatch::getLottoMatchKey, Function.identity())));


    public LottoMatchKey getLottoMatchKey() {
        return lottoMatchKey;
    }

    public int getPrize() {
        return prize;
    }

}
