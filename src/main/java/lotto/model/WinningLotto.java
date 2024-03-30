package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WinningLotto {
    public static final String BONUS_NUMBER_DENIED = "보너스 번호는 당첨 로또 번호와 중복없이 입력하셔야 합니다.";

    private final Lotto winLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<String> winNumbers, LottoNumber bonusNumber) {
        this.winLotto = Lotto.createLottoFrom(winNumbers);
        this.bonusNumber = generateBonusNumber(winNumbers, bonusNumber);
    }

    private LottoNumber generateBonusNumber(List<String> winNumbers, LottoNumber bonusNumber) {
        if (isDuplicatedBonusNumber(winNumbers, bonusNumber.getLottoNumber())) {
            throw new IllegalArgumentException(BONUS_NUMBER_DENIED);
        }

        return bonusNumber;
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
        if (!PrizeEnum.isBonusMatchedFrom(countOfWinNumbers)) {
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
