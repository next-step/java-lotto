package lotto.domain;

public class BonusNumber {
    private int bonusNumber;
    private final int LOTTO_START_NUMBER = 0;
    private final int LOTTO_END_NUMBER = 45;

    public BonusNumber(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < LOTTO_START_NUMBER || bonusNumber > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException("보너스 번호는 0 ~ 45 숫자를 입력해야 합니다.");
        }
    }
}
