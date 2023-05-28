package lotto.domain;

import java.util.List;
import java.util.Map;

public class WinningStatus {
    private final Map<Prize, Integer> winningStatus;

    private WinningStatus(Map<Prize, Integer> winningStatus) {
        this.winningStatus = winningStatus;
    }

    public static WinningStatus from(List<Prize> prizeTypesOfTickets) {
        Map<Prize, Integer> map = Prize.winningStatus(prizeTypesOfTickets);
        return new WinningStatus(map);
    }


    public int countOfPrize(Prize prize) {
        return winningStatus.get(prize);
    }
}
