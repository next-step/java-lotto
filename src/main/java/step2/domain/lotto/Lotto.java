package step2.domain.lotto;

import step2.domain.rank.MatchedCount;
import step2.domain.rank.Rank;
import views.LottoFormatter;

import java.util.List;

public class Lotto {
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers, LottoRule lottoRule) {
        if (!lottoRule.isSatisfied(lottoNumbers)) {
            throw new IllegalArgumentException("규칙을 만족하지 않는 숫자 입력입니다");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(LottoRule lottoRule) {
        this.lottoNumbers = lottoRule.generateLotto();
    }

    public Rank determineRank(WinningLotto winningLotto) {
        Rank matchedRank = Rank.NO_RANK;
        for (Rank rank : Rank.values()) {
            matchedRank = findMatchedRank(winningLotto, matchedRank, rank);
        }
        return matchedRank;
    }

    private Rank findMatchedRank(WinningLotto winningLotto, Rank currentRank, Rank candidateRank) {
        if (candidateRank.matches(compareWith(winningLotto))) {
            return candidateRank;
        }
        return currentRank;
    }

    private MatchedCount compareWith(WinningLotto winningLotto) {
        int matchedCount = winningLotto.countMatchedNumbers(this.lottoNumbers);
        return new MatchedCount(matchedCount);
    }

    public LottoFormatter generateFormatter() {
        return new LottoFormatter(this.lottoNumbers);
    }
}
