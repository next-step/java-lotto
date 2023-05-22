package lotto.domain;

import java.util.Map;

public class WinningStatus {
    private final Map<PrizeType, Integer> winningStatus;

    private WinningStatus(Map<PrizeType, Integer> winningStatus) {
        this.winningStatus = winningStatus;
    }

    public static WinningStatus from(Map<PrizeType, Integer> winningStatus) {
        return new WinningStatus(winningStatus);
    }

    public int countOfPrize(PrizeType prizeType) {
        return winningStatus.get(prizeType);
    }
}
