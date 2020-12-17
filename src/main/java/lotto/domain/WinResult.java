package lotto.domain;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class WinResult {
    private final List<Lotto> purchasedLotto;
    private final String winNumbers;
    private final int purchaseAmount;
    private final Map<WinType, Integer> winResultMap;

    public WinResult(List<Lotto> purchasedLotto, String winNumbers, Integer purchaseAmount) {
        this.purchasedLotto = purchasedLotto;
        this.winNumbers = winNumbers;
        this.purchaseAmount = purchaseAmount;
        this.winResultMap = getWinResultMap();
    }

    public String getYield() {
        int totalWinnings = winResultMap.entrySet().stream()
                .mapToInt(it -> it.getKey().getWinnings() * it.getValue())
                .sum();

        double yield = (double) totalWinnings / purchaseAmount;
        DecimalFormat format = new DecimalFormat("#.##");
        format.setRoundingMode(RoundingMode.DOWN);
        return format.format(yield);
    }

    public Map<WinType, Integer> getResults() {
        winResultMap.remove(WinType.NO_MATCH);

        return winResultMap;
    }

    private Map<WinType, Integer> getWinResultMap() {
        LottoWinningResults winningChecker = new LottoWinningResults();
        return winningChecker.checkWinLotto(purchasedLotto, winNumbers);
    }
}
