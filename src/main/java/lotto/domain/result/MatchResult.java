package lotto.domain.result;

import java.util.Objects;
import lotto.domain.LOTTO_REWARD;

public class MatchResult {
    private int matchedLottoNumberCount;
    private LOTTO_REWARD lottoReward;

    MatchResult(int matchedLottoNumberCount, LOTTO_REWARD lottoReward) {
        this.matchedLottoNumberCount = matchedLottoNumberCount;
        this.lottoReward = lottoReward;
    }

    long getMatchReward() {
        return matchedLottoNumberCount * lottoReward.getReward();
    }

    void addMatchCount() {
        ++matchedLottoNumberCount;
    }

    public int getMatchedLottoNumberCount() {
        return matchedLottoNumberCount;
    }

    public LOTTO_REWARD getLottoReward() {
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
        return this.matchedLottoNumberCount == matchResult.matchedLottoNumberCount && this.lottoReward == matchResult.lottoReward;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchedLottoNumberCount, lottoReward);
    }
}
