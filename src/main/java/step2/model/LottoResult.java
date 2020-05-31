package step2.model;

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
    SIX(LottoMatchCount.of(6), 2_000_000_000L);

    private static final Map<LottoMatchCount, LottoResult> LOTTO_RESULTS =
        Collections.unmodifiableMap(Stream.of(values())
            .collect(Collectors.toMap(LottoResult::getLottoMatchCount, Function.identity())));

    private final LottoMatchCount matchCount;
    private final Long price;

    LottoResult(LottoMatchCount matchCount, Long price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public static LottoResult of(int count) {
        return Optional.ofNullable(LOTTO_RESULTS.get(LottoMatchCount.of(count)))
            .orElseThrow(() -> new IllegalArgumentException("매칭 되는 갯수는 0 ~ 6 사이 입니다."));
    }

    public Integer getMatchCount() {
        return matchCount.toInt();
    }

    public Long getPrice() {
        return price;
    }

    public boolean isZeroPrice() {
        return price.equals(0L);
    }

    private LottoMatchCount getLottoMatchCount() {
        return matchCount;
    }
}
