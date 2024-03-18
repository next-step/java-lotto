package model;

public class LottoWinningNumber {

    private final WinningNumbers winningNumbers;
    private final LottoNumber bonusNumber;

    public LottoWinningNumber(final WinningNumbers winningNumbers, final LottoNumber bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank match(final Lotto lotto) {
        final int countOfMatch = lotto.findMatchNumberCount(winningNumbers);
        final boolean contains = lotto.getNumbers().contains(bonusNumber.getValue());
        return Rank.determine(countOfMatch, contains);
    }

    private void validate(final WinningNumbers winningNumbers, final LottoNumber lottoNumber) {
        if (winningNumbers.contains(lottoNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 같으면 안 됩니다.");
        }
    }
}
