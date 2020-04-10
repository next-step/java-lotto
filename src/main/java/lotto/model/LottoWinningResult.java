package lotto.model;

import lotto.model.wrapper.LottoPrice;
import lotto.model.wrapper.LottoWinningResultMatchId;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoWinningResult {
    NONE(0, BonusNumberMatchingStatus.ANYWAY, 0L),
    ONE(1, BonusNumberMatchingStatus.ANYWAY, 0L),
    TWO(2, BonusNumberMatchingStatus.ANYWAY, 0L),
    THREE(3, BonusNumberMatchingStatus.ANYWAY, 5_000L),
    FOUR(4, BonusNumberMatchingStatus.ANYWAY, 50_000L),
    FIVE(5, BonusNumberMatchingStatus.UN_MATCH, 1_500_000L),
    FIVE_WITH_BONUS(5, BonusNumberMatchingStatus.MATCH, 30_000_000L),
    SIX(6, BonusNumberMatchingStatus.ANYWAY, 2_000_000_000L),
    ;

    private static final Map<LottoWinningResultMatchId, LottoWinningResult> LOTTO_RESULTS = Collections.unmodifiableMap(
            Stream.of(values())
                    .collect(Collectors.toMap(LottoWinningResult::getLottoMatchCount, Function.identity())));

    private final LottoWinningResultMatchId lottoWinningResultMatchId;
    private final LottoPrice price;

    LottoWinningResult(final int winningNumbersMatchCount, final BonusNumberMatchingStatus bonusNumberMatchingStatus, final long price) {
        this.lottoWinningResultMatchId = LottoWinningResultMatchId.newInstance(winningNumbersMatchCount, bonusNumberMatchingStatus);
        this.price = LottoPrice.of(price);
    }

    public static LottoWinningResult of(final LottoWinningResultMatchId lottoWinningResultMatchId) {
        LottoWinningResult lottoWinningResult = LOTTO_RESULTS.get(lottoWinningResultMatchId);

        if (lottoWinningResult == null) {
            throw new IllegalArgumentException("일치하는 당첨 케이스가 없습니다.");
        }

        return lottoWinningResult;
    }

    public static LottoWinningResult of(final int matchCount, final boolean matchBonusNumber) {
        return of(LottoWinningResultMatchId.newInstance(matchCount, matchBonusNumber));
    }

    public int getLottoWinningResultMatchId() {
        return lottoWinningResultMatchId.toInt();
    }

    public long getPrice() {
        return price.getPrice();
    }

    public boolean isBlank() {
        return price.equals(LottoPrice.of(0L));
    }

    private LottoWinningResultMatchId getLottoMatchCount() {
        return lottoWinningResultMatchId;
    }
}
