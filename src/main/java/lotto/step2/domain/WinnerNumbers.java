package lotto.step2.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinnerNumbers {
    private final Set<LottoNumber> nums;
    private final LottoNumber bonusNumber;

    public WinnerNumbers(final String winnerNumbersText, final int bonusWinnerNumber) {
        final Set<LottoNumber> integers = conventStringToLottoNumberSet(winnerNumbersText);
        validateSize(integers);

        this.nums = Collections.unmodifiableSet(integers);

        final LottoNumber bonusLottoNumber = new LottoNumber(bonusWinnerNumber);
        validateBonusWinnerNumber(bonusLottoNumber);

        this.bonusNumber = bonusLottoNumber;
    }

    private void validateBonusWinnerNumber(final LottoNumber bonusLottoNumber) {
        if (this.nums.contains(bonusLottoNumber)) {
            throw new IllegalArgumentException("bonus winner number must not be in winner nums");
        }
    }

    private static Set<LottoNumber> conventStringToLottoNumberSet(final String winnerNumbersText) {
        return Arrays.stream(winnerNumbersText.split(", "))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    public Set<LottoNumber> nums() {
        return nums;
    }

    public LottoResults matchLottos(final List<Lotto> lottos) {
        final LottoResults lottoResults = new LottoResults();

        for (final Lotto lotto : lottos) {
            lottoResults.incrementRankCount(calculateLottoRank(lotto.nums()));
        }

        return lottoResults;
    }

    private LottoRank calculateLottoRank(final Set<LottoNumber> lottoNums) {
        return LottoRank.findByCountAndBonusMatching(calculateLottoNumsMatchingCount(lottoNums), lottoNums.contains(bonusNumber));
    }

    private int calculateLottoNumsMatchingCount(final Set<LottoNumber> lottoNums) {
        return (int) lottoNums.stream()
                .filter(nums::contains)
                .count();
    }

    private void validateSize(final Set<LottoNumber> nums) {
        if (nums.size() != 6) {
            throw new IllegalArgumentException("winner nums size must be 6");
        }
    }
}
