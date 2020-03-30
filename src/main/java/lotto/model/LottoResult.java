package lotto.model;

import lotto.model.wrapper.LottoMatchCount;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoResult {
    NONE(LottoMatchCount.of(0), 0L),
    ONE(LottoMatchCount.of(1), 0L),
    TWO(LottoMatchCount.of(2), 0L),
    THREE(LottoMatchCount.of(3), 5_000L),
    FOUR(LottoMatchCount.of(4), 50_000L),
    FIVE(LottoMatchCount.of(5), 1_500_000L),
    SIX(LottoMatchCount.of(6), 2_000_000_000L),
    ;

    private static final Map<LottoMatchCount, LottoResult> LOTTO_RESULTS = Collections.unmodifiableMap(
            Stream.of(values())
                    .collect(Collectors.toMap(LottoResult::getLottoMatchCount, Function.identity())));

    private final LottoMatchCount matchCount;
    private final long price;

    LottoResult(final LottoMatchCount matchCount, final long price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public static LottoResult of(final int count) {
        return Optional.ofNullable(LOTTO_RESULTS.get(LottoMatchCount.of(count)))
                .orElseThrow(() -> new IllegalArgumentException("Match Count must between 0 and 6."));
    }

    public Integer getMatchCount() {
        return matchCount.toInt();
    }

    public long getPrice() {
        return price;
    }

    public boolean isBlank() {
        return price == 0L;
    }

    private LottoMatchCount getLottoMatchCount() {
        return matchCount;
    }
}
