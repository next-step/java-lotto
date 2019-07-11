package lottogame.domain;

public class WinningLottoNumber {

    final int[] winningNumber;
    final int bonusBall;

    public WinningLottoNumber(String inputWinningNumber, int bonusBall) {
        this.winningNumber = LottoUtil.coverStrToArr(inputWinningNumber);
        this.bonusBall = LottoUtil.checkBonusball(bonusBall);
    }

    int[] getWinningNumber() {
        return winningNumber;
    }
}
