package step2.domain.lotto;

import step2.domain.rank.RankType;

import java.util.Set;

public class WinningLotto {
    private final Lotto winningLotto;
    private final Integer bonusNumber;

    public WinningLotto(Lotto winningLotto, Integer bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public WinningLotto(Lotto winningLotto) {
        this(winningLotto, null);
    }

    public Set<Integer> matchedWith(Lotto lotto) {
        return winningLotto.matchedWith(lotto);
    }

    public Set<Integer> notMatchedWith(Lotto lotto) {
        return winningLotto.notMatchedWith(lotto);
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

    public boolean isBonusNumberPresent(Set<Integer> number) {
        return number.contains(this.bonusNumber);
    }
}
