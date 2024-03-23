package autoLotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoWinChecker {
    private Map<Integer, Integer> winLottos;

    public LottoWinChecker(String winNumbersAsString, List<Lotto> lottos) {
        this.winLottos = createWinLotto(winNumbersAsString, lottos);
    }

    private Map<Integer, Integer> createWinLotto(String winNumbersAsString, List<Lotto> lottos) {
        List<Integer> winLotto = retrieveWinLottoAsListInteger(winNumbersAsString);
        return countWinLotto(winLotto, lottos);
    }

    private List<Integer> retrieveWinLottoAsListInteger(String winNumbersInString) {
        Lotto lotto = Lotto.createLottoFrom(winNumbersInString);
        List<Integer> lottoAsListInteger = lotto.getLottoAsListInteger();
        return lottoAsListInteger;
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
        Set<LottoNumber> targetLotto = lotto.getLotto();
        int matchingNumbers = 0;

        for (LottoNumber number : targetLotto) {
            matchingNumbers += hasWinNumber(winLotto, number.getLottoNumber());
        }

        return matchingNumbers;
    }

    private void saveOnlyPrize(Map<Integer, Integer> result, int countOfWinNumbers) {
        if (countOfWinNumbers < PrizeResultEnum.THREE_MATCHED.getMatchedCount()) {
            return;
        }

        result.put(countOfWinNumbers, result.getOrDefault(countOfWinNumbers, 0) + 1);
    }

    private int hasWinNumber(List<Integer> winLotto, Integer targetLottoNumber) {
        if(winLotto.contains(targetLottoNumber)) {
            return 1;
        }

        return 0;
    }

    public Map<Integer, Integer> getWinLottos() {
        return this.winLottos;
    }
}
