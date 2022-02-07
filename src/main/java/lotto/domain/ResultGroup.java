package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class ResultGroup {

    private Map<WinningResult, Integer> resultGroup;

    public ResultGroup() {
        this.resultGroup = new HashMap<>();
        for (WinningResult winningResult : WinningResult.values()) {
            resultGroup.put(winningResult, 0);
        }
    }

    public void updateResult(WinningResult result) {
        int currentCount = resultGroup.get(result);
        resultGroup.put(result, currentCount + 1);
    }

    public int howManyHave(WinningResult result) {
        return resultGroup.get(result);
    }
}
