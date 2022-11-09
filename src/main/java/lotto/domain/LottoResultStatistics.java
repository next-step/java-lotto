package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class LottoResultStatistics {

    private static final int DEFAULT_COUNT = 0;
    private static final int INCREASE_STEP = 1;

    private final Map<LottoResult, Integer> resultCounts;

    public LottoResultStatistics(final List<LottoResult> lottoResults) {
        resultCounts = new HashMap<>();
        for (final LottoResult lottoResult : lottoResults) {
            increaseResultCount(lottoResult);
        }
    }

    public Money getTotalWiningMoney() {
        return getFirstRankPrizeMoney().multiply(getFirstRankCount())
            .plus(getSecondRankPrizeMoney().multiply(getSecondRankCount()))
            .plus(getThirdRankPrizeMoney().multiply(getThirdRankCount()))
            .plus(getFourthRankPrizeMoney().multiply(getFourthRankCount()))
            .plus(getFifthRankPrizeMoney().multiply(getFifthRankCount()));
    }

    public LottoNumberMatchCount getFirstRankLottoNumberMatchCount() {
        return LottoResult.FIRST.getLottoNumberMatchCount();
    }

    public int getFirstRankCount() {
        return getCount(LottoResult.FIRST);
    }

    public Money getFirstRankPrizeMoney() {
        return LottoResult.FIRST.getPrizeMoney();
    }

    public LottoNumberMatchCount getSecondRankLottoNumberMatchCount() {
        return LottoResult.SECOND.getLottoNumberMatchCount();
    }

    public int getSecondRankCount() {
        return getCount(LottoResult.SECOND);
    }

    public Money getSecondRankPrizeMoney() {
        return LottoResult.SECOND.getPrizeMoney();
    }

    public LottoNumberMatchCount getThirdRankLottoNumberMatchCount() {
        return LottoResult.THIRD.getLottoNumberMatchCount();
    }

    public int getThirdRankCount() {
        return getCount(LottoResult.THIRD);
    }

    public Money getThirdRankPrizeMoney() {
        return LottoResult.THIRD.getPrizeMoney();
    }

    public LottoNumberMatchCount getFourthRankLottoNumberMatchCount() {
        return LottoResult.FOURTH.getLottoNumberMatchCount();
    }

    public int getFourthRankCount() {
        return getCount(LottoResult.FOURTH);
    }

    public Money getFourthRankPrizeMoney() {
        return LottoResult.FOURTH.getPrizeMoney();
    }

    public LottoNumberMatchCount getFifthRankLottoNumberMatchCount() {
        return LottoResult.FIFTH.getLottoNumberMatchCount();
    }

    public int getFifthRankCount() {
        return getCount(LottoResult.FIFTH);
    }

    public Money getFifthRankPrizeMoney() {
        return LottoResult.FIFTH.getPrizeMoney();
    }

    private int getCount(final LottoResult result) {
        return resultCounts.getOrDefault(result, DEFAULT_COUNT);
    }

    private void increaseResultCount(final LottoResult result) {
        resultCounts.put(result, resultCounts.getOrDefault(result, DEFAULT_COUNT) + INCREASE_STEP);
    }

}
