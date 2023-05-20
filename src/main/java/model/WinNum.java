package model;

import java.util.ArrayList;
import java.util.List;

public class WinNum {
    private List<Integer> winNum = new ArrayList<>();
    private int bonus;

    public WinNum(List<Integer> winnerNums, int bonus) {
        for (int num : winnerNums) {
            this.winNum.add(new LottoNumber(num).getLottoNumber());
        }
        this.bonus = new LottoNumber(bonus).getLottoNumber();
    }

    public List<Integer> getWinNum() {
        return this.winNum;
    }

    public boolean matchBonus(Lotto lotto) {
        return lotto.contains(this.bonus);
    }

    public int matchCount(Lotto lotto) {
        return (int) winNum.stream()
                .filter(lotto::contains)
                .count();
    }
}
