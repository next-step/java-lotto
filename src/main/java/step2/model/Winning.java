package step2.model;

import java.util.List;

public class Winning {
    private final Lotto winningNumber;
    private final Bonus bonus;

    public Winning(Lotto winningNumber, Bonus bonus) {
        this.winningNumber = winningNumber;
        this.bonus = bonus;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber.getLottoNumbers();
    }

    public int getBonus() {
        return bonus.getBonusNumber();
    }
}
