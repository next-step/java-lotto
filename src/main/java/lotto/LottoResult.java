package lotto;

import java.util.Map;

public class LottoResult {
    private static final int INT_DEFAULT_VALUE = 0;
    private Map<LottoType, Integer> winnings;

    public LottoResult(Map<LottoType, Integer> winnings) {
        this.winnings = winnings;
    }

    public Map<LottoType, Integer> getWinnings() {
        return winnings;
    }

    public double computeEarning() {
        double earnings = 0.0;
        for (LottoType lottoType : LottoType.values()) {
            int winningCount = winnings.getOrDefault(lottoType, INT_DEFAULT_VALUE);
            earnings += lottoType.computeEarning(winningCount);
        }
        return earnings;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (LottoType lottoType : LottoType.values()) {
            int winningCount = winnings.getOrDefault(lottoType, 0);
            buffer.append(lottoType + "- " + winningCount + "개\n");
        }
        return buffer.toString();
    }
}
