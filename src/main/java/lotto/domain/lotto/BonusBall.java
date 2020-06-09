package lotto.domain.lotto;

import lotto.domain.prize.WinningNumbers;

public class BonusBall {

    public static final int START_RANGE = 1;
    public static final int END_RANGE = 45;
    private int bonusBall;

    public BonusBall(int bonusBall, WinningNumbers winningNumbers) {
        checkDuplicate(bonusBall, winningNumbers);
        checkInRange(bonusBall);
        this.bonusBall = bonusBall;
    }

    public static BonusBall create(int bonusBall, WinningNumbers winningNumbers) {
        return new BonusBall(bonusBall, winningNumbers);
    }

    private void checkInRange(int bonusBall) {
        if (isInRange(bonusBall)) {
            throw new IllegalArgumentException("보너스 볼이 유효하지 않습니다");
        }
    }

    private boolean isInRange(int bonusBall) {
        return bonusBall < START_RANGE || bonusBall > END_RANGE;
    }

    private void checkDuplicate(int bonusBall, WinningNumbers winningNumbers) {
        if (winningNumbers.isExist(bonusBall)){
            throw new IllegalArgumentException("보너스 볼과 당첨 번호가 중복 됩니다");
        }
    }
}
