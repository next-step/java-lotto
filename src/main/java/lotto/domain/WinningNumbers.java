package lotto.domain;

public class WinningNumbers {
    private final LottoNumbers winningNumbers;

    private final LottoNumber bonusNumber;

    public WinningNumbers(final LottoNumbers winningNumbers, final LottoNumber bonusNumber) {
        validateContains(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateContains(final LottoNumbers winningNumbers, final LottoNumber bonusNumber) {
        if (winningNumbers.hasLottoNumber(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public LottoStatus checkWinning(final LottoNumbers lottoNumbers) {
        HitCount hitCount = lottoNumbers.checkHitCount(winningNumbers);
        BonusNumberStatus bonusNumberStatus = checkContainsBonusBall(lottoNumbers);
        return LottoStatus.find(hitCount, bonusNumberStatus);
    }

    private BonusNumberStatus checkContainsBonusBall(final LottoNumbers lottoNumbers) {
        if (lottoNumbers.hasLottoNumber(bonusNumber)) {
            return BonusNumberStatus.MATCH;
        }
        return BonusNumberStatus.MISS;
    }
}
