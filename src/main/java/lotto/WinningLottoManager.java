package lotto;

import java.util.HashMap;
import java.util.List;

public class WinningLottoManager {
    List<Integer> winningNumber;
    HashMap<WinningAmount, Integer> winningLottos = new HashMap<>();

    public WinningLottoManager(List<Integer> winningNumber) {
        this.winningNumber = winningNumber;
        for (WinningAmount winningAmount : WinningAmount.values()) {
            winningLottos.put(winningAmount, 0);
        }
    }

    public void countWinning(Lotto lotto) {
        Integer countMatch = lotto.countWinningNumber(winningNumber);
        WinningAmount winningAmount = WinningAmount.findWinningAmountByMatchCount(countMatch);
        winningLottos.merge(winningAmount, 1, Integer::sum);
    }

    public final HashMap<WinningAmount, Integer> findWinningLottos() {
        return winningLottos;
    }
}
