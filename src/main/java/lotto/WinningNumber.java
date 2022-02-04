package lotto;

import java.util.List;

public class WinningNumber {

    private final List<Integer> winningNumber;
    private int bonusBall;

    public WinningNumber(List<Integer> winningNumber, LottoRules lottoRules) {
        WinningNumberValidator winningNumberValidator = new WinningNumberValidator(lottoRules);
        winningNumberValidator.validateWinningNumber(winningNumber);
        this.winningNumber = winningNumber;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int getBonusBall() {
        return bonusBall;
    }

    public void setBonusBall(int bonusBall) {
        this.bonusBall = bonusBall;
    }

}
