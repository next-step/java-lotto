package step2.domain.lotto;

import step2.domain.rank.MatchedCount;
import step2.domain.rank.Rank;

import java.util.List;
import java.util.Set;

public class WinningLotto {
    public final List<Integer> winningNumbers;
    public final Integer bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningLotto(List<Integer> winningNumbers) {
        this(winningNumbers, null);
    }

    public Rank determineRank(Lotto lotto) {
        Rank matchedRank = Rank.NO_RANK;
        for (Rank rank : Rank.values()) {
            matchedRank = findMatchedRank(lotto, matchedRank, rank);
        }
        return matchedRank;
    }

    private Rank findMatchedRank(Lotto lotto, Rank currentRank, Rank candidateRank) {
        if (isWinningLotto(lotto, candidateRank)) {
            return candidateRank;
        }
        return currentRank;
    }

    private boolean isWinningLotto(Lotto lotto, Rank candidateRank) {
        if (candidateRank == Rank.SECOND) {
            Set<Integer> matchingNumbers = lotto.findMatchingNumbers(this.winningNumbers);
            Set<Integer> notMatchingNumbers = lotto.findNotMatchingNumbers(this.winningNumbers);
            if (matchingNumbers.size() == 5 && notMatchingNumbers.size() == 1 && notMatchingNumbers.contains(this.bonusNumber)) {
                return true;
            }
        }
        return candidateRank.matches(compareWith(lotto), false);
    }

    private MatchedCount compareWith(Lotto lotto) {
        Set<Integer> matchedCount = lotto.findMatchingNumbers(this.winningNumbers);
        return new MatchedCount(matchedCount);
    }
}
