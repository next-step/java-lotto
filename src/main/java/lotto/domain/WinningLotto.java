package lotto.domain;

import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;
import static lotto.domain.PrizeLevel.BONUS_MATCHING_COUNT;
import static lotto.domain.PrizeLevel.getPrizeLevel;

public class WinningLotto {
    private final List<LottoNo> lottoNumbers;
    private final LottoNo bonusNumber;

    public WinningLotto(List<LottoNo> lottoNumbers, LottoNo bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto from(List<Integer> numbers, int bonus) {
        List<LottoNo> lottoNumbers = numbers.stream()
            .map(LottoNo::new)
            .collect(toUnmodifiableList());

        return new WinningLotto(lottoNumbers, new LottoNo(bonus));
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
