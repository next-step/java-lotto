package model;

import java.util.HashMap;
import java.util.Map;

public class LotteryStatics {
    private Map<Rank, Integer> lotteryStatics = new HashMap<>();
    private double gross;

    public LotteryStatics(int buyAmount, Lottos lottos, WinNum winNum) {
        for (Lotto lotto : lottos.getLottos()) {
            int countOfMatch = winNum.matchCount(lotto);
            boolean matchBonus = winNum.matchBonus(lotto);
            this.lotteryStatics.merge(Rank.valueOf(countOfMatch, matchBonus), 1, Integer::sum);
        }

        this.gross = Math.round((double) getTotalPrice() / buyAmount * 100) / 100.0;
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

}
