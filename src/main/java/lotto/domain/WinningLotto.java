package lotto.domain;

import lotto.exceptions.InputFormatException;
import lotto.utils.StringParser;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private List<Integer> winningNumbers;
    private int bonusBall;

    public WinningLotto(String splitWinningLine, int bonusBall) {
        winningNumbers = new ArrayList<>();
        this.bonusBall = bonusBall;
        makeWinningNumber(splitWinningLine);
    }

    private void makeWinningNumber(String splitWinningLine) {
        for (String winningNum : StringParser.StringParserByDelimeter(splitWinningLine, ",")) {
            int num = Integer.parseInt(winningNum.trim());
            validationCheck(num);
            this.winningNumbers.add(num);
        }
    }

    private void validationCheck(int num) {
        if (!(num >= 1 && num <= 45) || this.bonusBall == num) {
            throw new InputFormatException();
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
