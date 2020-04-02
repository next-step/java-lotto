package lotto.model;

import lotto.model.wrapper.LottoMatchCount;
import lotto.model.wrapper.LottoResultMatchId;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoResult {
    NONE(LottoResultMatchId.newInstance(LottoMatchCount.of(0), LottoBonusMatchResult.ANYWAY), 0L),
    ONE(LottoResultMatchId.newInstance(LottoMatchCount.of(1), LottoBonusMatchResult.ANYWAY), 0L),
    TWO(LottoResultMatchId.newInstance(LottoMatchCount.of(2), LottoBonusMatchResult.ANYWAY), 0L),
    THREE(LottoResultMatchId.newInstance(LottoMatchCount.of(3), LottoBonusMatchResult.ANYWAY), 5_000L),
    FOUR(LottoResultMatchId.newInstance(LottoMatchCount.of(4), LottoBonusMatchResult.ANYWAY), 50_000L),
    FIVE(LottoResultMatchId.newInstance(LottoMatchCount.of(5), LottoBonusMatchResult.UN_MATCH), 1_500_000L),
    FIVE_WITH_BONUS(LottoResultMatchId.newInstance(LottoMatchCount.of(5), LottoBonusMatchResult.MATCH), 30_000_000L),
    SIX(LottoResultMatchId.newInstance(LottoMatchCount.of(6), LottoBonusMatchResult.ANYWAY), 2_000_000_000L),
    ;

    private static final Map<LottoResultMatchId, LottoResult> LOTTO_RESULTS = Collections.unmodifiableMap(
            Stream.of(values())
                    .collect(Collectors.toMap(LottoResult::getLottoMatchCount, Function.identity())));

    private final LottoResultMatchId matchCount;
    private final long price;

    LottoResult(final LottoResultMatchId matchCount, final long price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public static LottoResult of(final LottoResultMatchId lottoResultMatchId) {
        return Optional.ofNullable(LOTTO_RESULTS.get(lottoResultMatchId))
                .orElseThrow(() -> new IllegalArgumentException("Unacceptable Match Id."));
    }

    public int getMatchCount() {
        return matchCount.toInt();
    }

    public long getPrice() {
        return price;
    }

    public boolean isBlank() {
        return price == 0L;
    }

    private LottoResultMatchId getLottoMatchCount() {
        return matchCount;
    }
}
