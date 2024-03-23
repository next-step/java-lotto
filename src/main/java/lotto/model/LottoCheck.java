package lotto.model;

import java.util.*;

public class LottoCheck {
    private final Map<Integer, Integer> winLottos;

    public LottoCheck(String winningNumber, List<Lotto> lottos) {
        this.winLottos = createWinLotto(winningNumber, lottos);
    }

    private Map<Integer, Integer> createWinLotto(String winningNumber, List<Lotto> lottos) {
        List<Integer> winLotto = retrieveWinLotto(winningNumber);

        if (!Validator.isValidLottoSize(winLotto) || !Validator.isValidLottoNumbers(winLotto)) {
            throw new IllegalArgumentException("당첨 번호의 개수는 0 ~ 6개이며, 각 번호는 1 이상 45 이하의 값만 가능합니다.");
        }
        return countWinLotto(winLotto, lottos);
    }

    private List<Integer> retrieveWinLotto(String winningNumber) {
        Lotto lotto = new Lotto(winningNumber);
        return lotto.getLotto();
    }

    private Map<Integer, Integer> countWinLotto(List<Integer> winLotto, List<Lotto> lottos) {
        Map<Integer, Integer> result = new HashMap<>();

        for (Lotto lotto : lottos) {
            int countOfWinNumbers = compareWinNumbers(winLotto, lotto);
            saveOnlyPrize(result, countOfWinNumbers);
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

    private void saveOnlyPrize(Map<Integer, Integer> result, int countOfWinNumbers) {
        if (countOfWinNumbers < PrizeEnum.THREE_MATCHED.getMatchCount()) {
            return;
        }

        result.put(countOfWinNumbers, result.getOrDefault(countOfWinNumbers, 0) + 1);
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
