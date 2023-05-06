package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WinngCount {
    Map<Integer, Integer> mapPriceCount = new HashMap<>();

    public WinngCount(Lotto[] lottos, WinnerRule winnerRule, ArrayList<Integer> winngNum) {
        for (Lotto lotto : lottos) {
            int prize = winnerRule.getWinnerPrice(lotto.getLotto(), winngNum);
            if (prize > 0) {
                this.mapPriceCount.merge(prize, 1, Integer::sum);
            }
        }
    }

    public Map<Integer, Integer> getMapPriceCount() {
        return mapPriceCount;
    }

    public int sumPrize() {
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : this.mapPriceCount.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            sum += key * value;
        }

        return sum;
    }
}
