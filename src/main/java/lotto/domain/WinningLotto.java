package lotto.domain;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        validBonusNumber(winningNumbers, bonusNumber);
        this.winningLotto = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validBonusNumber(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new RuntimeException();
        }
    }

    public LottoMatch compareLotto(Lotto lotto) {
        int matchCount = winningLotto.compareLotto(lotto);
        boolean bonusMatch = false;
        if (matchCount == Rank.SECOND.getLottoMatch().getMatchCount()) {
            bonusMatch = lotto.contains(bonusNumber);
        }
        return new LottoMatch(matchCount, bonusMatch);
    }
}
