package lotto.domain;

public class BonusNumber {

    private static final int ZERO = 0;
    private static final int HIT_COUNT = 1;

    private int bonusNumber;

    BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    int getHitCount(Lotto lotto) {
        if (lotto.isContainsWinNumber(this.bonusNumber)) {
            return HIT_COUNT;
        } else return ZERO;
    }
}
