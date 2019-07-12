package lottogame.domain;

import java.util.Arrays;

public class WinningLottoNumber {

    final int[] winningNumber;
    final int bonusBall;

    public WinningLottoNumber(String inputWinningNumber, int bonusBall) {
        this.winningNumber = LottoUtil.coverStrToArr(inputWinningNumber);
        this.bonusBall = LottoUtil.checkBonusball(bonusBall);
        checkDuplicate();
    }

    int[] getWinningNumber() {
        return winningNumber;
    }

    private void checkDuplicate(){
        if(Arrays.stream(winningNumber).filter(i -> i == bonusBall).count() !=0){
            throw new IllegalArgumentException("로또번호와 보너스 번호가 중복이 됩니다. 프로그램을 종료합니다.");
        }
    }
}
