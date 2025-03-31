package lotto.domain;

import java.util.List;

import static lotto.domain.PrizeLevel.BONUS_MATCHING_COUNT;
import static lotto.domain.PrizeLevel.getPrizeLevel;

public class WinningLotto {
    private final List<Integer> lottoNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> lottoNumbers, int bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public PrizeLevel countMatchingNumbers(Lotto lotto) {
        int count = (int) lottoNumbers.stream()
            .filter(lotto::containsNumber)
            .count();

        return getPrizeLevel(count, isBonus(count, lotto));
    }

    private boolean isBonus(int count, Lotto lotto) {
        return count == BONUS_MATCHING_COUNT && lotto.containsNumber(bonusNumber);
    }
}
