package lotto.model;

import java.util.*;

public class LottoCheck {
    private final Map<Integer, Integer> winLottos;

    public LottoCheck(String winningNumber, List<Lotto> lottos) {
        this.winLottos = createWinLotto(winningNumber, lottos);
    }

    private Map<Integer, Integer> createWinLotto(String winningNumber, List<Lotto> lottos) {
        List<Integer> winLotto = findWinLotto(winningNumber);
        Validator.validateLotto(winLotto);

        return countWinLotto(winLotto, lottos);
    }

    private List<Integer> findWinLotto(String winningNumber) {
        Lotto lotto = new Lotto(winningNumber);

        return lotto.getLotto();
    }

    private Map<Integer, Integer> countWinLotto(List<Integer> winLotto, List<Lotto> lottos) {
        Map<Integer, Integer> result = new HashMap<>();

        for (Lotto lotto : lottos) {
            int winNumberCount = compareWinNumbers(winLotto, lotto);
            includedRankCheck(result, winNumberCount);
        }

        return result;
    }

    private int compareWinNumbers(List<Integer> winLotto, Lotto lotto) {
        List<Integer> targetLotto = lotto.getLotto();

        int matchingNumbers = 0;

        for (int number : targetLotto) {
            matchingNumbers += hasWinNumber(winLotto, number);
        }

        return matchingNumbers;
    }

    private void includedRankCheck(Map<Integer, Integer> result, int winNumberCount) {
        if (winNumberCount < 3) {
            return;
        }
        result.put(winNumberCount, result.getOrDefault(winNumberCount, 0) + 1);
    }

    private int hasWinNumber(List<Integer> winLotto, int targetNumber) {
        if(winLotto.contains(targetNumber)) {
            return 1;
        }
        return 0;
    }

    public Map<Integer, Integer> getWinLottos() {
        return this.winLottos;
    }
}
