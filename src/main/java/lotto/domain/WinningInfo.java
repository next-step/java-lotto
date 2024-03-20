package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class WinningInfo {
    private static final int MATCH_COUNT = 3;

    private final List<Integer> winningInfo;

    public WinningInfo() {
        this.winningInfo = Arrays.asList(0,0,0,0);
    }

    public void checkWinning(int countNumber) {
        if (countNumber >= MATCH_COUNT) {
            Integer winningCount = winningInfo.get(countNumber - MATCH_COUNT);
            winningInfo.set(countNumber - MATCH_COUNT, winningCount + 1);
        }
    }
}
