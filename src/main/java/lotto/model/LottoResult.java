package lotto.model;

import lotto.model.wrapper.LottoPrice;
import lotto.model.wrapper.LottoResultMatchId;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoResult {
    NONE(0, LottoBonusNumberMatchStatus.ANYWAY, 0L),
    ONE(1, LottoBonusNumberMatchStatus.ANYWAY, 0L),
    TWO(2, LottoBonusNumberMatchStatus.ANYWAY, 0L),
    THREE(3, LottoBonusNumberMatchStatus.ANYWAY, 5_000L),
    FOUR(4, LottoBonusNumberMatchStatus.ANYWAY, 50_000L),
    FIVE(5, LottoBonusNumberMatchStatus.UN_MATCH, 1_500_000L),
    FIVE_WITH_BONUS(5, LottoBonusNumberMatchStatus.MATCH, 30_000_000L),
    SIX(6, LottoBonusNumberMatchStatus.ANYWAY, 2_000_000_000L),
    ;

    private static final Map<LottoResultMatchId, LottoResult> LOTTO_RESULTS = Collections.unmodifiableMap(
            Stream.of(values())
                    .collect(Collectors.toMap(LottoResult::getLottoMatchCount, Function.identity())));

    private final LottoResultMatchId lottoResultMatchId;
    private final LottoPrice price;

    LottoResult(final int matchCount, final LottoBonusNumberMatchStatus lottoBonusNumberMatchStatus, final long price) {
        this.lottoResultMatchId = LottoResultMatchId.newInstance(matchCount, lottoBonusNumberMatchStatus);
        this.price = LottoPrice.of(price);
    }

    public static LottoResult of(final LottoResultMatchId lottoResultMatchId) {
        LottoResult lottoResult = LOTTO_RESULTS.get(lottoResultMatchId);

        if (lottoResult == null) {
            throw new IllegalArgumentException("일치하는 당첨 케이스가 없습니다.");
        }

        return lottoResult;
    }

    public static LottoResult of(int matchCount, boolean matchBonusNumber) {
        return of(LottoResultMatchId.newInstance(matchCount, matchBonusNumber));
    }

    public int getLottoResultMatchId() {
        return lottoResultMatchId.toInt();
    }

    public long getPrice() {
        return price.getPrice();
    }

    public boolean isBlank() {
        return price.equals(LottoPrice.of(0L));
    }

    private LottoResultMatchId getLottoMatchCount() {
        return lottoResultMatchId;
    }
}
