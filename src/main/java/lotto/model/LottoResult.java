package lotto.model;

import lotto.model.wrapper.LottoMatchCount;
import lotto.model.wrapper.LottoPrice;
import lotto.model.wrapper.LottoResultMatchId;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoResult {
    NONE(0, LottoBonusNumberMatch.ANYWAY, 0L),
    ONE(1, LottoBonusNumberMatch.ANYWAY, 0L),
    TWO(2, LottoBonusNumberMatch.ANYWAY, 0L),
    THREE(3, LottoBonusNumberMatch.ANYWAY, 5_000L),
    FOUR(4, LottoBonusNumberMatch.ANYWAY, 50_000L),
    FIVE(5, LottoBonusNumberMatch.UN_MATCH, 1_500_000L),
    FIVE_WITH_BONUS(5, LottoBonusNumberMatch.MATCH, 30_000_000L),
    SIX(6, LottoBonusNumberMatch.ANYWAY, 2_000_000_000L),
    ;

    private static final Map<LottoResultMatchId, LottoResult> LOTTO_RESULTS = Collections.unmodifiableMap(
            Stream.of(values())
                    .collect(Collectors.toMap(LottoResult::getLottoMatchCount, Function.identity())));

    private final LottoResultMatchId matchCount;
    private final LottoPrice price;

    LottoResult(final int matchCount, final LottoBonusNumberMatch lottoBonusNumberMatch, final long price) {
        this.matchCount = LottoResultMatchId.newInstance(LottoMatchCount.of(matchCount), lottoBonusNumberMatch);
        this.price = LottoPrice.of(price);
    }

    public static LottoResult of(final LottoResultMatchId lottoResultMatchId) {
        return Optional.ofNullable(LOTTO_RESULTS.get(lottoResultMatchId))
                .orElseThrow(() -> new IllegalArgumentException("일치하는 당첨 케이스가 없습니다."));
    }

    public int getMatchCount() {
        return matchCount.toInt();
    }

    public long getPrice() {
        return price.getPrice();
    }

    public boolean isBlank() {
        return price.equals(LottoPrice.of(0L));
    }

    private LottoResultMatchId getLottoMatchCount() {
        return matchCount;
    }
}
