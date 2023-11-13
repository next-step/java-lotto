package lotto.step2.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinnerNumbers {
    private final Set<LottoNumber> nums;

    public WinnerNumbers(final String winnerNumbersText) {
        final Set<LottoNumber> integers = conventStringToLottoNumberSet(winnerNumbersText);
        validateSize(integers);

        this.nums = Collections.unmodifiableSet(integers);
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
        return LottoRank.findByCount(
                (int) lottoNums.stream()
                        .filter(nums::contains)
                        .count());
    }

    private void validateSize(final Set<LottoNumber> nums) {
        if (nums.size() != 6) {
            throw new IllegalArgumentException("winner nums size must be 6");
        }
    }
}
