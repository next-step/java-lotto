package lotto.domain;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;


public class WinningFinder {
    private final List<LottoNumber> WINNING_NUMBER;
    private LottoNumber bonusNumber;
    private HashMap<WinningAmount, Integer> winningLottos = new HashMap<>();

    public WinningFinder(List<LottoNumber> winningNumber) {
        WINNING_NUMBER = winningNumber;
        for (WinningAmount winningAmount : WinningAmount.values()) {
            winningLottos.put(winningAmount, 0);
        }
    }

    public WinningFinder(List<LottoNumber> winningNumber, int bonusNumber) {
        this.bonusNumber = new LottoNumber(bonusNumber);
        WINNING_NUMBER = winningNumber;
        for (WinningAmount winningAmount : WinningAmount.values()) {
            winningLottos.put(winningAmount, 0);
        }
    }

    public void countWinning(Lotto lotto) {
        int countMatch = lotto.countWinningNumber(WINNING_NUMBER);
        System.out.println("countMatch : " + countMatch);
        WinningAmount winningAmount = WinningAmount.findWinningAmountByMatchCount(countMatch, hasBonus());
        mergeIfMoreThanThreeMatch(winningAmount);
    }

    private boolean hasBonus() {
        return bonusNumber != null;
    }

    private void mergeIfMoreThanThreeMatch(WinningAmount winningAmount) {
        if (winningAmount != null) {
            winningLottos.merge(winningAmount, 1, Integer::sum);
        };
    }

    public final HashMap<WinningAmount, Integer> findWinningLottos() {
        LinkedHashMap<WinningAmount, Integer> sortedWinningLottos = new LinkedHashMap<>();
        for (WinningAmount winningAmount : WinningAmount.values()) {
            sortedWinningLottos.put(winningAmount, winningLottos.get(winningAmount));
        }
        return sortedWinningLottos;
    }
}
