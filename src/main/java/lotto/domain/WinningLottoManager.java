package lotto.domain;

import java.util.HashMap;
import java.util.List;

public class WinningLottoManager {
    private final List<Integer> WINNING_NUMBER;
    private HashMap<WinningAmount, Integer> winningLottos = new HashMap<>();

    public WinningLottoManager(List<Integer> winningNumber) {
        this.WINNING_NUMBER = winningNumber;
        for (WinningAmount winningAmount : WinningAmount.values()) {
            winningLottos.put(winningAmount, 0);
        }
    }

    public void countWinning(Lotto lotto) {
        Integer countMatch = lotto.countWinningNumber(WINNING_NUMBER);
        WinningAmount winningAmount = WinningAmount.findWinningAmountByMatchCount(countMatch);
        mergeIfMoreThanThreeMatch(winningAmount);
    }

    private void mergeIfMoreThanThreeMatch(WinningAmount winningAmount) {
        if (winningAmount != null) {
            winningLottos.merge(winningAmount, 1, Integer::sum);
        };
    }

    public final HashMap<WinningAmount, Integer> findWinningLottos() {
        return winningLottos;
    }
}
