package Model;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

public class LotteryStatics {
    private ArrayList<int[]> lotteryStatics = new ArrayList<>();

    public LotteryStatics(WinRule winRule, WinCount winCount) {

        for (Map.Entry<Integer, Integer> entry : winRule.getWinRule().entrySet()) {
            int[] result = new int[3];
            Integer equalCount = entry.getKey();
            Integer prize = entry.getValue();
            Integer count = winCount.getWinCount().get(equalCount);
            result[0] = equalCount;
            result[1] = prize;
            result[2] = Optional.ofNullable(count).orElse(0);
            lotteryStatics.add(result);
        }
    }

    public ArrayList<int[]> getLotteryStatics() {
        return this.lotteryStatics;
    }

    public int getSumPirze() {
        int sum = 0;
        for (int i = 0; i < this.lotteryStatics.size(); i++) {
            sum += lotteryStatics.get(i)[1] * lotteryStatics.get(i)[2];
        }

        return sum;
    }
}
