package step2.model;

import java.util.List;

public class Winning {
    private WinningNumber winningNumber;
    private Bonus bonus;

    public Winning(WinningNumber winningNumber, Bonus bonus) {
        this.winningNumber = winningNumber;
        this.bonus = bonus;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber.getWinningNumbers();
    }

    public int getBonus() {
        return bonus.getBonusNumber();
    }
}
