package step2.domain.lotto;

import step2.domain.rank.RankType;

import java.util.List;
import java.util.Set;

public class WinningLotto {
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningLotto(List<Integer> winningNumbers) {
        this(winningNumbers, null);
    }

    public RankType determineRank(Lotto lotto) {
        RankType matchedRank = RankType.NO_RANK;
        for (RankType rank : RankType.values()) {
            matchedRank = findMatchedRank(lotto, matchedRank, rank);
        }
        return matchedRank;
    }

    private RankType findMatchedRank(Lotto lotto, RankType currentRank, RankType candidateRank) {
        if (isWinningLotto(lotto, candidateRank)) {
            return candidateRank;
        }
        return currentRank;
    }

    private boolean isWinningLotto(Lotto lotto, RankType candidateRank) {
        return candidateRank.matches(this, lotto);
    }

    public Set<Integer> matchedWith(Lotto lotto) {
        return lotto.findMatchingNumbers(this.winningNumbers);
    }

    public Set<Integer> notMatchedWith(Lotto lotto) {
        return lotto.findNotMatchingNumbers(this.winningNumbers);
    }

    public boolean isBonusNumberPresent(Set<Integer> number) {
        return number.contains(this.bonusNumber);
    }
}
