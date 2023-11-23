package lotto.domain;

public class WinningNumber {

    static final String DUPLICATE_BONUS_NUMBER = "당첨 번호에 포함된 값입니다.";

    private Lotto winningNumbers;
    private int bonusNumber;

    public WinningNumber(Lotto winningNumbers, int bonusNumber) {
        validation(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int matchNumbers(Lotto lotto) {
        int answerCount = lotto.matchNumbers(winningNumbers);
        return answerCount;
    }

    public boolean matchBonusNumber(Lotto lotto) {
        return lotto.matchBonusNumber(bonusNumber);
    }

    private void validation(Lotto winningNumbers, int bonusNumber) {
        boolean containsCheck = winningNumbers.getLotto().stream()
                .anyMatch(num -> num.getNumber() == bonusNumber);
        if (containsCheck) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER);
        }
    }
}
