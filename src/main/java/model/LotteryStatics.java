package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LotteryStatics {
    private Map<Rank, Integer> lotteryStatics = new HashMap<>();
    double gross;

    public LotteryStatics(int buyAmount, List<Lotto> lottos, List<Integer> winNum) {
        for (Lotto lotto : lottos) {
            int countOfMatch = getEqualCount(lotto.getLotto(), winNum);
            this.lotteryStatics.merge(Rank.valueOf(countOfMatch), 1, Integer::sum);
        }

        this.gross = Math.round((double) getTotalPrice() / buyAmount *100) / 100.0;
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

    public double getGross() {
        return this.gross;
    }

    private int getEqualCount(List<Integer> inputNums, List<Integer> winLotto) {
        List<Integer> copyList = new ArrayList<>(inputNums);

        int equalNum = (int) copyList.stream()
                .filter(winLotto::contains)
                .count();

        return equalNum;
    }

}
