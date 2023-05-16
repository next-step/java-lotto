package model;

import java.util.ArrayList;
import java.util.List;

public class WinNum {
    List<Integer> winNum = new ArrayList<>();
    private int bonus;

    public WinNum(List<Integer> winnerNums, int bonus) {
        this.winNum = winnerNums;
        this.bonus = bonus;
    }

    public List<Integer> getWinNum() {
        return this.winNum;
    }

    public boolean matchBonus(Lotto lotto) {
        if (lotto.getLotto().contains(this.bonus)){
            return true;
        }

        return false;
    }

    public int matchCount(Lotto lotto) {
        List<Integer> copyList = new ArrayList<>(winNum);

        int equalNum = (int) copyList.stream()
                .filter(lotto.getLotto()::contains)
                .count();

        return equalNum;
    }
}
