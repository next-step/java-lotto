package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LotteryStatics {
    private Map<Rank, Integer> lotteryStatics = new HashMap<>();

    public LotteryStatics(WinRule winRule, List<Lotto> lottos, List<Integer> winNum) {
        for (Lotto lotto : lottos) {
            int countOfMatch = getEqualCount(lotto.getLotto(), winNum);
            this.lotteryStatics.merge(Rank.valueOf(countOfMatch), 1, Integer::sum);
        }
    }

    public Map<Rank, Integer> getLotteryStatics() {
        return this.lotteryStatics;
    }

    public int getTotalPrice() {
        int sum = 0;
        for (Map.Entry<Rank, Integer> entry : this.lotteryStatics.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            sum += rank.getWinningMoney() * count;
        }
        return sum;
    }

    private int getEqualCount(List<Integer> inputNums, List<Integer> winLotto) {
        inputNums.retainAll(winLotto);

        int equalNum = inputNums.size();

        return equalNum;
    }

}
