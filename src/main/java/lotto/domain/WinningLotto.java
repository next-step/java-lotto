package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private List<Integer> winningNumbers;
    private int bonusBall;

    public WinningLotto() {
        winningNumbers = new ArrayList<>();
    }

    public WinningLotto(String[] splitWinningLine, int bonusBall) {
        this();
        makeWinningNumber(splitWinningLine);
        this.bonusBall = bonusBall;
    }

    private void makeWinningNumber(String[] splitWinningLine) {
        for (int i = 0; i < splitWinningLine.length; i++) {
            this.winningNumbers.add(Integer.parseInt(splitWinningLine[i].trim()));
        }
    }

    public int getRankCount(Lotto lotto, int count) {
        for (Integer number : winningNumbers) {
            count = getCount(lotto, count, number);
        }

        return count;
    }

    private int getCount(Lotto lotto, int count, Integer number) {
        if (lotto.getLottoNumbers().contains(number)) {
            count++;
        }
        return count;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusBall() {
        return bonusBall;
    }
}
