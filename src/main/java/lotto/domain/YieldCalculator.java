package lotto.domain;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Map;

public class YieldCalculator {
    private final int purchaseAmount;
    private final Map<WinType, Integer> winResultMap;

    public YieldCalculator(int purchaseAmount, Map<WinType, Integer> winResultMap) {
        this.purchaseAmount = purchaseAmount;
        this.winResultMap = winResultMap;
    }

    public String calculateYield() {
        int totalWinnings = winResultMap.entrySet().stream()
                .mapToInt(it -> it.getKey().getWinnings() * it.getValue())
                .sum();

        double yield = (double) totalWinnings / purchaseAmount;
        DecimalFormat format = new DecimalFormat("#.##");
        format.setRoundingMode(RoundingMode.DOWN);
        return format.format(yield);
    }
}
