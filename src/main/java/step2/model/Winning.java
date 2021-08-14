package step2.model;

import java.util.ArrayList;
import java.util.List;

public class Winning {
    private final WinningNumber winningNumber;
    private final Bonus bonus;

    public Winning(WinningNumber winningNumber, Bonus bonus) {
        this.winningNumber = winningNumber;
        this.bonus = bonus;
    }

    public List<Integer> getWinningNumber() {
        List<Integer> results = new ArrayList<>();

        for (LottoNumber number : winningNumber.getWinningNumbers()) {
            results.add(number.getLottoNumber());
        }

        return results;
    }

    public int getBonus() {
        return bonus.getBonusNumber().getLottoNumber();
    }
}
