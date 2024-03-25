package autoLotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoWinChecker {
    private static final String BONUS_NUMBER_DENIED = "당첨 번호와 중복 없이 1 ~ 45 사이의 숫자 1개만 입력이 가능합니다.";

    private final Lotto winLotto;
    private final LottoNumber bonusNumber;

    public LottoWinChecker(List<String> winNumbers, int bonusNumber) {
        this.winLotto = Lotto.createLottoFrom(winNumbers);
        this.bonusNumber = generateBonusNumber(winNumbers, bonusNumber);
    }

    private LottoNumber generateBonusNumber(List<String> winNumbers, int bonusNumber) {
        if (isDuplicatedBonusNumber(winNumbers, bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DENIED);
        }

        return new LottoNumber(bonusNumber);
    }

    private boolean isDuplicatedBonusNumber(List<String> winNumbers, int bonusNumber) {
        String bonusNumberAsString = String.valueOf(bonusNumber);
        return winNumbers.contains(bonusNumberAsString);
    }

    public Map<PrizeEnum, Integer> checkWinLottos(List<Lotto> lottos) {
        return countMatchedWinLottos(lottos);
    }

    private Map<PrizeEnum, Integer> countMatchedWinLottos(List<Lotto> lottos) {
        Map<PrizeEnum, Integer> result = new EnumMap<>(PrizeEnum.class);

        for (Lotto lotto : lottos) {
            int countOfWinNumbers = compareWinNumbers(lotto);
            boolean isBonusMatched = compareBonusNumber(lotto, countOfWinNumbers);
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

    private boolean compareBonusNumber(Lotto userLotto, int countOfWinNumbers) {
        if (PrizeEnum.isBonusMatchedFrom(countOfWinNumbers)) {
            return false;
        }

        return userLotto.containsNumber(bonusNumber.getLottoNumber());
    }

    private int hasWinNumber(Integer targetLottoNumber) {
        if (winLotto.containsNumber(targetLottoNumber)) {
            return 1;
        }

        return 0;
    }
}
