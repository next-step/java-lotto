package lotto.domain;

public class Bonus {

    private final int bonusNumber;

    public Bonus(int bonusNumber, Lotto winningLotto) {
        validateNumber(bonusNumber);
        validateDuplicate(bonusNumber, winningLotto);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45사이여야 합니다.");
        }
    }

    private void validateDuplicate(int bonusNumber, Lotto winningLotto) {
        if (winningLotto.getLotto().contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 중복되는 보너스 번호는 사용할 수 없습니다.");
        }
    }
}
