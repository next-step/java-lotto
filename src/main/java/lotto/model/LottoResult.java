package lotto.model;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoResult {
    SIX(6, 2000000000L),
    FIVE(5,1500000L),
    FOUR(4,50000L),
    THREE(3,5000L),
    TWO(2,0L),
    ONE(1,0L),
    NONE(0,0L)
    ;

    private static final Map<Integer, LottoResult> LOTTO_RESULTS = Collections.unmodifiableMap(
            Stream.of(values())
                    .collect(Collectors.toMap(LottoResult::getMatchCount, Function.identity())));

    private final Integer matchCount;
    private final Long price;

    LottoResult(final Integer matchCount, final Long price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public static LottoResult of(int count) {
        return Optional.ofNullable(LOTTO_RESULTS.get(count))
                .orElseThrow(() -> new IllegalArgumentException("Match Count must between 0 and 6."));
    }

    private Integer getMatchCount() {
        return matchCount;
    }

    public Long getPrice() {
        return price;
    }
}
