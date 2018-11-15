package domain.winningStatus;

import domain.Prize;

import java.util.HashMap;
import java.util.Map;

public class GeneralWinningStatus implements WinningStatus {

    private final Map<Prize, Integer> result = new HashMap<>();

    public GeneralWinningStatus() {
        for (Prize prize : Prize.values()) {
            result.put(prize, 0);
        }
    }

    @Override
    public void putPrize(Prize prize) {
        result.put(prize, result.get(prize) + 1);
    }

    @Override
    public int getPrizeCount(Prize prize) {
        return result.get(prize);
    }

    @Override
    public double getProfit() {
        int total = result.values().stream().mapToInt(i -> i).sum();
        int win = total - result.getOrDefault(Prize.NONE, 0);

        return Double.parseDouble(String.format("%.2f", (win / (double) total)));
    }
}
