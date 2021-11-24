package lotto.domain;

public class BonusBall {

    private final Number bonusBall;

    public Number getBonusBall() {
        return bonusBall;
    }

    public BonusBall(WinningNumbers winningNumbers, Number bonusBall) {
        checkDuplicated(winningNumbers, bonusBall);
        this.bonusBall = bonusBall;
    }

    private void checkDuplicated(WinningNumbers winningNumbers, Number bonusBall) {
        if (winningNumbers.checkContainNumber(bonusBall)) {
            throw new IllegalArgumentException("당첨 번호중에 이미 존재합니다");
        }
    }
}
