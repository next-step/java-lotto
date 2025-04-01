package step2.domain.lotto;

import step2.domain.rank.RankType;

public class WinningLotto {
    private final Lotto winningLotto;
    private final Integer bonusNumber;

    public WinningLotto(Lotto winningLotto, Integer bonusNumber) {
        if (lottoContainsBonusNumber(winningLotto, bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }

        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public WinningLotto(Lotto winningLotto) {
        this(winningLotto, null);
    }

    public LottoNumbers matchedWith(Lotto lotto) {
        return winningLotto.matchedWith(lotto);
    }

    public LottoNumbers notMatchedWith(Lotto lotto) {
        return winningLotto.notMatchedWith(lotto);
    }

    public RankType determineRank(Lotto lotto) {
        RankType matchedRank = RankType.NO_RANK;
        for (RankType rank : RankType.values()) {
            matchedRank = findMatchedRank(lotto, matchedRank, rank);
        }
        return matchedRank;
    }

    private boolean lottoContainsBonusNumber(Lotto winningLotto, Integer bonusNumber) {
        return winningLotto.contains(bonusNumber);

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

    public boolean isBonusNumberPresent(LottoNumbers number) {
        return number.contains(this.bonusNumber);
    }
}
