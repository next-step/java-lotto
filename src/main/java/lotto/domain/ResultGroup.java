package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class ResultGroup {

    private final Map<WinningResult, Integer> resultGroup;

    public ResultGroup() {
        this.resultGroup = new HashMap<>();
        for (WinningResult winningResult : WinningResult.values()) {
            resultGroup.put(winningResult, 0);
        }
    }

    public void updateResult(WinningResult result) {
        resultGroup.put(result, resultGroup.get(result) + 1);
    }

    public int howManyHave(WinningResult result) {
        return resultGroup.get(result);
    }

    public double getProfits(Money money) {
        double profit = 0;
        for (WinningResult result : WinningResult.winningResults()) {
            profit += howManyHave(result) * result.prize();
        }
        return profit / money.value();
    }
}
