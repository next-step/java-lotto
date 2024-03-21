package model;

import java.util.List;

public class LottoWinningNumber {

    private final WinningNumbers winningNumbers;
    private final LottoNumber bonusNumber;

    public LottoWinningNumber(final WinningNumbers winningNumbers, final LottoNumber bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoWinningNumber of(final List<Integer> winningNumbersInput, final int bonusNumberInput) {
        final WinningNumbers winningNumbers = new WinningNumbers(winningNumbersInput);
        final LottoNumber bonusNumber = new LottoNumber(bonusNumberInput);
        return new LottoWinningNumber(winningNumbers, bonusNumber);
    }

    public Rank match(final Lotto lotto) {
        final int countOfMatch = lotto.findMatchNumberCount(winningNumbers);
        final boolean contains = lotto.contains(bonusNumber);
        return Rank.determine(countOfMatch, contains);
    }

    private void validate(final WinningNumbers winningNumbers, final LottoNumber lottoNumber) {
        if (winningNumbers.contains(lottoNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 같으면 안 됩니다.");
        }
    }
}
