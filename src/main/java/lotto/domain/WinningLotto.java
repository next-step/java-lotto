package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.enums.PrizeMoney.*;

public class WinningLotto {
    private final Lotto lotto;
    private final List<Integer> lastWinningNumbers;
    private Map<Integer, Integer> winningCounts;
    private double rateOfReturn;

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

        winningCounts =  lotto.match(lastWinningNumbers);
    }

    private void calculateRateOfReturn() {
        double totalPrize = 0;
        if (winningCounts.containsKey(3)) totalPrize += winningCounts.get(3) * THREE_MATCHES.prizeMoney();
        if (winningCounts.containsKey(4)) totalPrize += winningCounts.get(4) * FOUR_MATCHES.prizeMoney();
        if (winningCounts.containsKey(5)) totalPrize += winningCounts.get(5) * FIVE_MATCHES.prizeMoney();
        if (winningCounts.containsKey(6)) totalPrize += winningCounts.get(6) * SIX_MATCHES.prizeMoney();

        rateOfReturn = totalPrize / (lotto.count() * 1_000);
    }
}
