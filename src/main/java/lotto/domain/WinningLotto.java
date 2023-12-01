package lotto.domain;

import java.util.*;


public class WinningLotto {
    private Lotto winningLotto;
    private LottoNumber bonus;
    private Map<WinningAmount, Integer> countByMatch  = new HashMap<>();

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        winningLotto.checkWinningHasBonus(bonusNumber);
        this.winningLotto = winningLotto;
        bonus = bonusNumber;
        for (WinningAmount winningAmount : WinningAmount.values()) {
            countByMatch.put(winningAmount, 0);
        }
    }

    public void countWinning(Lotto lotto) {
        int countMatch = lotto.countWinningNumber(winningLotto.getNumbers());
        WinningAmount winningAmount = WinningAmount.findWinningAmountByMatchCount(countMatch, lotto.hasBonus(bonus));
        countByMatch.merge(winningAmount, 1, Integer::sum);
    }

    public final LinkedHashMap<WinningAmount, Integer> sortWinningLottos() {
        LinkedHashMap<WinningAmount, Integer> sortedWinningLottos = new LinkedHashMap<>();
        for (WinningAmount winningAmount : WinningAmount.values()) {
            sortedWinningLottos.put(winningAmount, countByMatch.get(winningAmount));
        }
        return sortedWinningLottos;
    }
}
