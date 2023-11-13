package lotto.step2.domain;

import lotto.step2.validator.NumberValidator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinnerNumbers {
    private final Set<Integer> nums;

    public WinnerNumbers(final String winnerNumbersText) {
        final Set<Integer> integers = conventStringToIntegerSet(winnerNumbersText);
        NumberValidator.validateNums(integers);

        this.nums = Collections.unmodifiableSet(integers);
    }

    private static Set<Integer> conventStringToIntegerSet(final String winnerNumbersText) {
        return Arrays.stream(winnerNumbersText.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }

    public Set<Integer> nums() {
        return nums;
    }

    public LottoResults matchLottos(final List<Lotto> lottos) {
        final LottoResults lottoResults = new LottoResults();

        for (final Lotto lotto : lottos) {
            lottoResults.incrementRankCount(calculateLottoRank(lotto.nums()));
        }

        return lottoResults;
    }

    private LottoRank calculateLottoRank(final Set<Integer> lottoNums) {
        return LottoRank.findByCount(
                (int) lottoNums.stream()
                        .filter(nums::contains)
                        .count());
    }
}
