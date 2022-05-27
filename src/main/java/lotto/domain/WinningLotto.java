package lotto.domain;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningNumbers, LottoNumber bonusNumber) {
        validateBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void validateBonusNumber(Lotto winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.hasBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호는 중복되면 안됩니다.");
        }
    }

    public Ranking findMatchRanking(Lotto lotto) {
        int matchCount = winningNumbers.countMatchNumber(lotto);
        boolean matchBonus = lotto.hasBonusNumber(bonusNumber);
        return Ranking.findMatchRanking(matchCount, matchBonus);
    }
}
