package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {

    private final int bonusNum;

    public WinningLotto(List<Integer> numList, int bonusNum) {
        super(numList);
        this.bonusNum = bonusNum;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
