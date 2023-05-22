package model;

import java.util.ArrayList;
import java.util.List;

public class WinNum {
    private List<LottoNumber> winNum = new ArrayList<>();
    private LottoNumber bonus;

    public WinNum(List<Integer> winnerNums, int bonus) {
        for (int num : winnerNums) {
            this.winNum.add(new LottoNumber(num));
        }
        this.bonus = new LottoNumber(bonus);
    }

    public List<LottoNumber> getWinNum() {
        return this.winNum;
    }

    public boolean matchBonus(Lotto lotto) {
        return lotto.contains(this.bonus);
//        for (LottoNumber num : lotto.getLotto()) {
//            if (num.getLottoNumber() == this.bonus.getLottoNumber())
//                return true;
//        }
//
//        return false;
    }

    public int matchCount(Lotto lotto) {
        return (int) winNum.stream()
                .filter(lotto::contains)
                .count();
    }
}
