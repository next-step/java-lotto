package step2.model;

import static step2.model.LottoBonusResult.MATCHED;
import static step2.model.LottoBonusResult.NOTHING;
import static step2.model.LottoBonusResult.NOT_MATCHED;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoResult {
    NONE(LottoMatchCount.newInstance(0, NOTHING), 0L),
    ONE(LottoMatchCount.newInstance(1, NOTHING), 0L),
    TWO(LottoMatchCount.newInstance(2, NOTHING), 0L),
    THREE(LottoMatchCount.newInstance(3, NOTHING), 5_000L),
    FOUR(LottoMatchCount.newInstance(4, NOTHING), 50_000L),
    FIVE(LottoMatchCount.newInstance(5, NOT_MATCHED ), 1_500_000L),
    FIVE_WITH_BONUS(LottoMatchCount.newInstance(5, MATCHED), 30_000_000L),
    SIX(LottoMatchCount.newInstance(6, NOTHING), 2_000_000_000L);

    private static final Map<LottoMatchCount, LottoResult> LOTTO_RESULTS =
        Collections.unmodifiableMap(Stream.of(values())
            .collect(Collectors.toMap(LottoResult::getLottoMatchCount, Function.identity())));

    private final LottoMatchCount matchCount;
    private final Long price;

    LottoResult(LottoMatchCount matchCount, Long price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public static LottoResult of(LottoMatchCount lottoMatchCount) {
        return Optional.ofNullable(LOTTO_RESULTS.get(lottoMatchCount))
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
