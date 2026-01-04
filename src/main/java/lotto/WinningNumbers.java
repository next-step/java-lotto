package lotto;


import lotto.MatchResult;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningNumbers(Lotto winningLotto, LottoNumber bonusNumber) {
        validateNoDuplicate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateNoDuplicate(Lotto lotto, LottoNumber bonus) {
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없다.");
        }
    }

    public Rank match(Lotto lotto) {
        int matchCount = lotto.matchCount(winningLotto);
        boolean bonusMatched = lotto.contains(bonusNumber);
        return Rank.of(new MatchResult(matchCount, bonusMatched));
    }

    public WinningStatistics match(Lottos lottos) {
        WinningStatistics statistics = new WinningStatistics();
        for (Lotto lotto : lottos.values()) {
            statistics.add(match(lotto));
        }
        return statistics;
    }
}
