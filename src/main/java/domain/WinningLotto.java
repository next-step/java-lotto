package domain;

import java.util.List;

public class WinningLotto extends Lotto {
    private boolean isBonus;
    private Integer combineCount;
    private Integer bonusNumber;

    public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
        this.isBonus = isContains(bonusNumber);
    }

    public WinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    public WinningLotto(Integer combineCount, boolean isBonus) {
        this.combineCount = combineCount;
        this.isBonus = isBonus;
    }


    public int getReward() {
        return LottoRank.valueOf(combineCount, isBonus).getPriceRewards();
    }

    public boolean getCombineLotto(int combineNum, boolean isBonus) {
        return this.combineCount.equals(combineNum) && this.isBonus == isBonus;
    }

    public WinningLotto getCombineNumbers(Lotto lotto) {
        this.combineCount = getCombineCount(lotto);
        this.isBonus = lotto.isContains(bonusNumber);
        return new WinningLotto(combineCount, isBonus);
    }

}
