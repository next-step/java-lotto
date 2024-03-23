package autoLotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoWinChecker {
    private Map<PrizeEnum, Integer> winLottos;

    public LottoWinChecker(String winNumbersAsString, List<Lotto> lottos, int bonusNumber) {
        this.winLottos = createWinLotto(winNumbersAsString, lottos, bonusNumber);
    }

    private Map<PrizeEnum, Integer> createWinLotto(String winNumbersAsString, List<Lotto> lottos, int bonusNumber) {
        Lotto winLotto = Lotto.createLottoFrom(winNumbersAsString);
        return countWinLotto(winLotto, lottos, bonusNumber);
    }

    private Map<PrizeEnum, Integer> countWinLotto(Lotto winLotto, List<Lotto> lottos, int bonusNumber) {
        Map<PrizeEnum, Integer> result = new HashMap<>();

        for (Lotto lotto : lottos) {
            int countOfWinNumbers = compareWinNumbers(winLotto, lotto);
            boolean isBonusMatched = compareBonusNumber(lotto, bonusNumber);
            PrizeEnum prize = PrizeEnum.getPrizeFrom(countOfWinNumbers, isBonusMatched);
            result.put(prize, result.getOrDefault(prize, 0) + 1);
        }

        return result;
    }

    private int compareWinNumbers(Lotto winLotto, Lotto lotto) {
        Set<LottoNumber> targetLotto = lotto.getLotto();
        int matchingNumbers = 0;

        for (LottoNumber number : targetLotto) {
            matchingNumbers += hasWinNumber(winLotto, number.getLottoNumber());
        }

        return matchingNumbers;
    }

    private boolean compareBonusNumber(Lotto userLotto, int bonusNumber) {
        return userLotto.containsNumber(bonusNumber);
    }

    private int hasWinNumber(Lotto winLotto, Integer targetLottoNumber) {
        if (winLotto.containsNumber(targetLottoNumber)) {
            return 1;
        }

        return 0;
    }

    public Map<PrizeEnum, Integer> getWinLottos() {
        return this.winLottos;
    }
}
