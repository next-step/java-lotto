package lotto.domain;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import static lotto.domain.WinningAmount.*;

public class WinningFinder {
    private final List<LottoNumber> WINNING_NUMBER;
    private HashMap<WinningAmount, Integer> winningLottos = new HashMap<>();

    public WinningFinder(List<LottoNumber> winningNumber) {
        WINNING_NUMBER = winningNumber;
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
        LinkedHashMap<WinningAmount, Integer> sortedWinningLottos = new LinkedHashMap<>();
        sortedWinningLottos.put(THREE_MATCH, winningLottos.get((THREE_MATCH)));
        sortedWinningLottos.put(FOUR_MATCH, winningLottos.get((FOUR_MATCH)));
        sortedWinningLottos.put(FIVE_MATCH, winningLottos.get((FIVE_MATCH)));
        sortedWinningLottos.put(SIX_MATCH, winningLottos.get((SIX_MATCH)));
        return sortedWinningLottos;
    }
}
