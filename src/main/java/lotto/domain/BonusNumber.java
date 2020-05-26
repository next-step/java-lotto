package lotto.domain;

import java.util.Objects;

public class BonusNumber {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final int bonusNumber;

    private BonusNumber(int bonusNumber, LottoNumber lastWinLottoNumber) {
        validate(bonusNumber, lastWinLottoNumber);
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber newInstance(int bonusNumber, LottoNumber lastWinLottoNumber) {
        return new BonusNumber(bonusNumber, lastWinLottoNumber);
    }

    private void validate(int bonusNumber, LottoNumber lastWinLottoNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("보너스 번호는 1 ~ 45 까지 입력 가능합니다.");
        }

        if (lastWinLottoNumber.isMatchNumber(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호에 포함된 번호를 입력할 수 없습니다.");
        }
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusNumber that = (BonusNumber) o;
        return bonusNumber == that.bonusNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusNumber);
    }
}
