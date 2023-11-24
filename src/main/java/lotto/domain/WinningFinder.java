package lotto.domain;

import java.util.*;


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
        boolean hasBonus = lotto.hasBonus(bonusNumber);
        WinningAmount winningAmount = WinningAmount.findWinningAmountByMatchCount(countMatch, hasBonus);
        mergeIfMoreThanThreeMatch(winningAmount);
    }

    private void mergeIfMoreThanThreeMatch(WinningAmount winningAmount) {
        if (winningAmount != null) {
            winningLottos.merge(winningAmount, 1, Integer::sum);
        };
    }

    public final LinkedHashMap<WinningAmount, Integer> findWinningLottos() {
        LinkedHashMap<WinningAmount, Integer> sortedWinningLottos = new LinkedHashMap<>();
        WinningAmount[] winningAmounts = checkBonusNumber(WinningAmount.values());

        for (WinningAmount winningAmount : winningAmounts) {
            sortedWinningLottos.put(winningAmount, winningLottos.get(winningAmount));
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
