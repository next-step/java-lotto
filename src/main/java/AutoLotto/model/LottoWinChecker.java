package autoLotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoWinChecker {
    private Lotto winLotto;

    public LottoWinChecker(List<String> winNumbers) {
        this.winLotto = Lotto.createLottoFrom(winNumbers);
    }

    public Map<PrizeEnum, Integer> checkWinLottos(List<Lotto> lottos, int bonusNumber) {
        return countMatchedWinLottos(lottos, bonusNumber);
    }

    private Map<PrizeEnum, Integer> countMatchedWinLottos(List<Lotto> lottos, int bonusNumber) {
        Map<PrizeEnum, Integer> result = new EnumMap<>(PrizeEnum.class);

        for (Lotto lotto : lottos) {
            int countOfWinNumbers = compareWinNumbers(lotto);
            boolean isBonusMatched = compareBonusNumber(lotto, bonusNumber, countOfWinNumbers);
            PrizeEnum prize = PrizeEnum.getPrizeFrom(countOfWinNumbers, isBonusMatched);
            result.put(prize, result.getOrDefault(prize, 0) + 1);
        }

        return result;
    }


    private int compareWinNumbers(Lotto lotto) {
        Set<LottoNumber> targetLotto = lotto.getLotto();
        int matchingNumbers = 0;

        for (LottoNumber number : targetLotto) {
            matchingNumbers += hasWinNumber(number.getLottoNumber());
        }

        return matchingNumbers;
    }


    private boolean compareBonusNumber(Lotto userLotto, int bonusNumber, int countOfWinNumbers) {
        if (countOfWinNumbers != PrizeEnum.SECOND.getMatchedCount()) {
            return false;
        }

        return userLotto.containsNumber(bonusNumber);
    }

    private int hasWinNumber(Integer targetLottoNumber) {
        if (winLotto.containsNumber(targetLottoNumber)) {
            return 1;
        }

        return 0;
    }
}
