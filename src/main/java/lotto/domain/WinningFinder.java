package lotto.domain;

import java.util.HashMap;
import java.util.LinkedHashMap;


public class WinningFinder {
    private Lotto winningLotto;
    private LottoNumber bonusNumber;
    private HashMap<WinningAmount, Integer> winningLottos = new HashMap<>();

    public WinningFinder(Lotto winningLotto) {
        this.winningLotto = winningLotto;
        for (WinningAmount winningAmount : WinningAmount.values()) {
            winningLottos.put(winningAmount, 0);
        }
    }

    public WinningFinder(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = new LottoNumber(bonusNumber);
        for (WinningAmount winningAmount : WinningAmount.values()) {
            winningLottos.put(winningAmount, 0);
        }
    }

    public void countWinning(Lotto lotto) {
        int countMatch = lotto.countWinningNumber(winningLotto.getNumbers());
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
