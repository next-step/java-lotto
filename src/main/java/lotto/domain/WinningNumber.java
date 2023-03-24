package lotto.domain;

import java.util.ArrayList;

public class WinningNumber {
    public ArrayList<Integer> winningNums;
    public int bonusNum;

    public WinningNumber(ArrayList<Integer> winningNumbers, int bonusNumber) {
        this.winningNums = winningNumbers;
        this.bonusNum = bonusNumber;
    }

    public ArrayList<Integer> getWinningNums() {
        return winningNums;
    }

    public int getBonusNums() {
        return bonusNum;
    }

}