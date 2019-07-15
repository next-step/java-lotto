package lottogame.domain;

import java.util.Arrays;

public class WinningLottoNumber {

    final int[] winningNumber;
    final int bonusBall;

    public WinningLottoNumber(String inputWinningNumber, int bonusBall) {
        this.winningNumber = LottoUtil.covertStrToArr(inputWinningNumber);
        this.bonusBall = LottoUtil.checkBonusball(bonusBall);
        checkDuplicate();
    }

    int[] getWinningNumber() {
        return winningNumber;
    }

    private void checkDuplicate() {
        if (Arrays.stream(winningNumber).filter(i -> i == bonusBall).count() != 0) {
            throw new IllegalArgumentException(LottoUtilStrData.WARNING_STR_WINNING_NUMBER_BONUS_DUPLICATE.getValue());
        }
    }
}
