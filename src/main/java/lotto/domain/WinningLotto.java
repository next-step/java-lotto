package lotto.domain;

import java.util.*;


public class WinningLotto {
    private Lotto winningLotto;
    private LottoNumber bonusNumber;
    private HashMap<WinningAmount, Integer> countByMatch  = new HashMap<>();

    public WinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
        for (WinningAmount winningAmount : WinningAmount.values()) {
            countByMatch.put(winningAmount, 0);
        }
    }

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = new LottoNumber(bonusNumber);
        for (WinningAmount winningAmount : WinningAmount.values()) {
            countByMatch.put(winningAmount, 0);
        }
    }

    public void countWinning(Lotto lotto) {
        int countMatch = lotto.countWinningNumber(winningLotto.getNumbers());
        boolean hasBonus = lotto.hasBonus(bonusNumber);
        WinningAmount winningAmount = WinningAmount.findWinningAmountByMatchCount(countMatch, hasBonus);
        mergeIfMoreThanThreeMatch(winningAmount);
    }

    private void mergeIfMoreThanThreeMatch(WinningAmount winningAmount) {
        if (winningAmount != null) {
            countByMatch.merge(winningAmount, 1, Integer::sum);
        };
    }

    public final LinkedHashMap<WinningAmount, Integer> sortWinningLottos() {
        LinkedHashMap<WinningAmount, Integer> sortedWinningLottos = new LinkedHashMap<>();
        WinningAmount[] winningAmounts = checkBonusNumber(WinningAmount.values());

        for (WinningAmount winningAmount : winningAmounts) {
            sortedWinningLottos.put(winningAmount, countByMatch.get(winningAmount));
        }
        return sortedWinningLottos;
    }

    private WinningAmount[] checkBonusNumber(WinningAmount[] winningAmounts) {
        if (bonusNumber == null) {
            List<WinningAmount> winningAmountsList = new ArrayList<>(Arrays.asList(WinningAmount.values()));
            winningAmountsList.remove(WinningAmount.FIVE_MATCH_AND_BONUS);
            WinningAmount[] filteredArray = winningAmountsList.toArray(new WinningAmount[0]);
            return filteredArray;
        }
        return winningAmounts;
    }
}
