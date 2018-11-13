package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private List<Integer> winningNumbers;
    private int bonusBall;

    public WinningLotto(String[] splitWinningLine, int bonusBall) {
        winningNumbers = new ArrayList<>();
        this.bonusBall = bonusBall;
        makeWinningNumber(splitWinningLine);
    }

    private void makeWinningNumber(String[] splitWinningLine) {
        for (String winningNum : splitWinningLine) {
            this.winningNumbers.add(Integer.parseInt(winningNum.trim()));
        }
    }

    public int getRankCount(Lotto lotto, int count) {
        for (Integer number : winningNumbers) {
            count = getCount(lotto, count, number);
        }

        return count;
    }

    private int getCount(Lotto lotto, int count, Integer number) {
        if (lotto.contains(number)) {
            count++;
        }

        return count;
    }

    public int getBonusBall() {
        return bonusBall;
    }
}
