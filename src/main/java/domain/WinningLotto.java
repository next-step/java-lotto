package domain;

import java.util.List;

public class WinningLotto {
    private boolean isBonus;
    private Integer combineCount;
    private Integer bonusNumber;
    private Lotto lotto;

    public WinningLotto(Lotto lotto, Integer bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
        this.isBonus = lotto.isContains(bonusNumber);
    }

    public WinningLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public WinningLotto(Integer combineCount, boolean isBonus) {
        this.combineCount = combineCount;
        this.isBonus = isBonus;
    }


    public int getReward() {
        return LottoRank.valueOf(combineCount, isBonus).getPriceRewards();
    }

    public boolean getCombineLotto(int combineNum, boolean isBonus) {
        return combineCount.equals(combineNum) && this.isBonus == isBonus;
    }

    public WinningLotto getCombineNumbers(Lotto lotto) {
        combineCount = this.lotto.getCombineCount(lotto);
        isBonus = lotto.isContains(bonusNumber);
        return new WinningLotto(combineCount, isBonus);
    }

    public int getCombineCount(Lotto lastLotto) {
        return lotto.getCombineCount(lastLotto);
    }
}
