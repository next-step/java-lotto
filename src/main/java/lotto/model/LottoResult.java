package lotto.model;

import lotto.model.wrapper.LottoMatchCount;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoResult {
    NONE(LottoMatchCount.newInstance(0, LottoBonusMatchResult.ANYWAY), 0L),
    ONE(LottoMatchCount.newInstance(1, LottoBonusMatchResult.ANYWAY), 0L),
    TWO(LottoMatchCount.newInstance(2, LottoBonusMatchResult.ANYWAY), 0L),
    THREE(LottoMatchCount.newInstance(3, LottoBonusMatchResult.ANYWAY), 5_000L),
    FOUR(LottoMatchCount.newInstance(4, LottoBonusMatchResult.ANYWAY), 50_000L),
    FIVE(LottoMatchCount.newInstance(5, LottoBonusMatchResult.UN_MATCH), 1_500_000L),
    FIVE_WITH_BONUS(LottoMatchCount.newInstance(5, LottoBonusMatchResult.MATCH), 30_000_000L),
    SIX(LottoMatchCount.newInstance(6, LottoBonusMatchResult.ANYWAY), 2_000_000_000L),
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

    public static LottoResult of(final LottoMatchCount lottoMatchCount) {
        return Optional.ofNullable(LOTTO_RESULTS.get(lottoMatchCount))
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
