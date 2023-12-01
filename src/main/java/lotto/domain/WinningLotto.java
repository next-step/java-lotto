package lotto.domain;

import java.util.*;


public class WinningLotto {
    private Lotto winningLotto;
    private LottoNumber bonus;
    private HashMap<WinningAmount, Integer> countByMatch  = new HashMap<>();

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        bonus = LottoNumber.valueOf(bonusNumber);
        checkWinningHasBonus(winningLotto, bonus);
        for (WinningAmount winningAmount : WinningAmount.values()) {
            countByMatch.put(winningAmount, 0);
        }
    }

    private void checkWinningHasBonus(Lotto winningLotto, LottoNumber bonus) {
        if (winningLotto.hasBonus(bonus)) {
            throw new IllegalArgumentException("Don`t put bonus in winning lotto");
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
