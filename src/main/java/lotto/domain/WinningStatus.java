package lotto.domain;

import java.util.List;
import java.util.Map;

public class WinningStatus {
    private final Map<Prize, Long> winningStatus;

    private WinningStatus(Map<Prize, Long> winningStatus) {
        this.winningStatus = winningStatus;
    }

    public static WinningStatus from(List<Prize> prizeTypesOfTickets) {
        Map<Prize, Long> map = Prize.winningStatus(prizeTypesOfTickets);
        return new WinningStatus(map);
    }


    public Long countOfPrize(Prize prize) {
        return winningStatus.getOrDefault(prize, 0L);
    }
}
