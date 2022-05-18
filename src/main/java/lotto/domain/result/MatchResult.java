package lotto.domain.result;

import java.util.Objects;
import lotto.domain.LottoReward;

public class MatchResult {
    private MatchCount matchedLottoNumberCount;
    private LottoReward lottoReward;

    MatchResult(int matchedLottoNumberCount, LottoReward lottoReward) {
        this.matchedLottoNumberCount = new MatchCount(matchedLottoNumberCount);
        this.lottoReward = lottoReward;
    }

    long getMatchReward() {
        return matchedLottoNumberCount.getMatchCount() * lottoReward.getReward();
    }

    void addMatchCount() {
        matchedLottoNumberCount.addMatchCount();
    }

    public int getMatchedLottoNumberCount() {
        return matchedLottoNumberCount.getMatchCount();
    }

    public LottoReward getLottoReward() {
        return lottoReward;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MatchResult matchResult = (MatchResult) obj;
        return this.matchedLottoNumberCount.equals(matchResult.matchedLottoNumberCount) && this.lottoReward == matchResult.lottoReward;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchedLottoNumberCount, lottoReward);
    }
}
