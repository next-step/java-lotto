package lotto.domain;

public class CorrectNumbers {

    private static final String DUPLICATE_NUMBER_EXCEPTION_MESSAGE = "로또 번호와 보너스 번호는 중복될 수 없습니다.";

    private final WinningNumbers winningNumbers;
    private final LottoNumber bonusNumber;

    public CorrectNumbers(final WinningNumbers winningNumbers, final LottoNumber bonusNumber) {
        validateDuplicateNumber(winningNumbers, bonusNumber);

        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateNumber(final WinningNumbers winningNumbers,
            final LottoNumber bonusNumber) {
        if (winningNumbers.get().contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
