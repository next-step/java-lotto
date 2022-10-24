package step2.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningMachine {

    private WinningMachine() {

    }

    public static WinningResult getWinningResult(Lottos lottos, List<Integer> winningNumbers) {
        Map<Integer, Integer> matchMap = new HashMap<>();
        for (Lotto lotto : lottos) {
            int match = lotto.getMatch(winningNumbers);
            matchMap.computeIfPresent(match, (key, value) -> value + 1);
            matchMap.putIfAbsent(match, 1);
        }
        return WinningResult.from(matchMap);
    }
}
