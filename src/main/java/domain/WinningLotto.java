package domain;

import utils.LottoGenerator;

import java.util.List;

public class WinningLotto{
    private List<Integer> numbers;
    private boolean isBonus;

    public WinningLotto(List<Integer> numbers, boolean isBonus) {
        this.numbers = numbers;
        this.isBonus = isBonus;
    }

    public int getCombineCount() {
        return numbers.size();
    }

    public int getReward() {
        return LottoRank.valueOf(getCombineCount(), isBonus).getPriceRewards();
    }

    public boolean isBonus() {
        return isBonus;
    }
}
