package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningLotto {

    private final Lotto lotto;
    private final List<Integer> lastWinningNumbers;
    private final Map<Integer, Integer> winningCounts;
    private double rateOfReturn;
    private static final int THREE_MATCHES = 5000;
    private static final int FOUR_MATCHES = 50000;
    private static final int FIVE_MATCHES = 1500000;
    private static final int SIX_MATCHES = 2000000000;

    public WinningLotto(Lotto lotto, List<Integer> lastWinningNumbers){
        this.lotto = lotto;
        this.lastWinningNumbers = lastWinningNumbers;
        this.winningCounts = new HashMap<>();
    }

    public Map<String, Object> winningResult(){

        matchingWinningNumberCount();
        calculateRateOfReturn();

        Map<String, Object> winningResult = new HashMap<>();
        winningResult.put("winningCounts", winningCounts);
        winningResult.put("rateOfReturn", rateOfReturn);

        return winningResult;
    }

    private void matchingWinningNumberCount(){
        for(LottoNumbers lottoNumbers : lotto.lotto()){
            long duplicateNumberCount = lastWinningNumbers.stream()
                                                          .filter(lottoNumbers.lottoNumbers()::contains)
                                                          .count();

            winningCounts.merge((int) duplicateNumberCount, 1, Integer::sum);
        }
    }

    private void calculateRateOfReturn() {
        double totalPrize = 0;
        if (winningCounts.containsKey(3)) totalPrize += winningCounts.get(3) * THREE_MATCHES;
        if (winningCounts.containsKey(4)) totalPrize += winningCounts.get(4) * FOUR_MATCHES;
        if (winningCounts.containsKey(5)) totalPrize += winningCounts.get(5) * FIVE_MATCHES;
        if (winningCounts.containsKey(6)) totalPrize += winningCounts.get(6) * SIX_MATCHES;

        rateOfReturn = totalPrize / lotto.lotto().size();
    }
}
