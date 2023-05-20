package model;

import java.util.ArrayList;
import java.util.List;

public class WinNum {
    List<Integer> winNum = new ArrayList<>();
    private int bonus;

    public WinNum(List<Integer> winnerNums, int bonus) {
        LottoNumber lottoNumber = new LottoNumber(winnerNums, bonus);
        this.winNum = lottoNumber.getLottoNumber();
        this.bonus = lottoNumber.getBonus();
    }

    public List<Integer> getWinNum() {
        return this.winNum;
    }

    public boolean matchBonus(Lotto lotto) {
        return lotto.contains(this.bonus);
    }

    public int matchCount(Lotto lotto) {
        return (int) winNum.stream()
                .filter(lotto.getLotto()::contains)
                .count();
    }
}
