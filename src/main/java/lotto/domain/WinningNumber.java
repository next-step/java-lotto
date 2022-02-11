package lotto.domain;

import java.util.List;

public class WinningNumber {
    
    private final Lotto winningNumber;
    private final int bonusBall;
    
    public WinningNumber(List<Integer> winningNumber, int bonusBall) {
        WinningNumberValidator winningNumberValidator = new WinningNumberValidator();
        winningNumberValidator.validateWinningNumber(winningNumber);
        winningNumberValidator.validateInRange(bonusBall);
        this.winningNumber = new Lotto(winningNumber);
        this.bonusBall = bonusBall;
    }
    
    public List<Integer> getWinningNumber() {
        return winningNumber.getNumbers();
    }
    
    public int getBonusBall() {
        return bonusBall;
    }
    
    
}
