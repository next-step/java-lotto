package domain.lotto;

import domain.MatchedCount;

import java.util.List;

public class Lotto {
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
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
}
